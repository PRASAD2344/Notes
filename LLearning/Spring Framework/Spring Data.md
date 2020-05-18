[Reference](https://www.linkedin.com/learning/spring-spring-data-2)

>### **Spring Data**
- Abstracts a way from any particular datasource
- Repository pattern
- Object-Relational Mapping(ORM)
- Mapping physical model to logical model
- In ORM mapping metadata using XML/annotations
- JPA oldest framework
- JPA is just a specification
- Implementations frameworks - Hibernate
- EntityManager ?
- @Table, @Entity, @Id, @GeneratedValue - Tells JPA to create value and for this reason will not include `id` in constructor, @Column
- ```java
  @PersistenceContext
  EntityManager entityManager;
  ```
- ```java
  @ManyToOne@JoinColumn(name="course_dept_id") 
  Department department; 
  ```
- ```java
  @OneToMany(mappedBy="department",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
  List<Course> courses;//mappedBy specifies column that of source class i.e., course
  ```
- ```java
  @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
  @JoinTable(name="Enrollment",
    joinColumns={@JoinColumn(name = "student_id")},
    inverseJoinColumns={@JoinColumn(name = "course_id")})
  private List<Course> enrolledCourses = new ArrayList<>();
  ```
- JPQL -Java Persistence Query Language - Portable to any database management system
- LazyInitializationException - When we try access lazily instantiated properties

>### **Spring Data JPA**
- Repository pattern instead of having EntityManager based operations
- ```java com.springframework.data.repository ```
- ```java public interface CrudRepository<T, ID> extends Repository<T, ID> ```
- save, saveAll(iterable)
- deleteByID, deleteAll(iterable), delete, deleteAll
- findById, findAllById, findAll, count, existsById(ID id)
- ```java public interface StudentRepository extends CrudRepository<Student,Integer> ```
- @Embeddable, @Embedded
- Spring Data Store Specific Interfaces
- JpaRepository extends CrudRepository. flush, saveAndFlush, deleteInBatch(iterable), deleteAllInBatch
- Differentiate between data repositories

>### **Special Features**
- Readonly repository pattern, @NoRepositoryBean
  ```java
    @NoRepositoryBean
    public interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T,ID>{
      //Declare only required methods
    }
  ```
- @Query annontation
- @CreatedDate, @LastModifiedBy, @CreatedBy, @LastModifiedDate
  ```java
    public class SpringSecurityAuditorAware implements AuditorAware<User>{
      public User getCurrentAuditor(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated()){
          return null;
        }
        return ((MyUserDetails)authentication.getPrincipal()).getUser();
      }
    }
  ```
- Auditable and AbstractAuditable
- Querydsl extension - QueryDslPredicateExecutor<Entity> - Predicate
- Spring Data Rest - spring-boot-starter-data-rest dependency in pom

>### **Spring Repostiroy Types**
1. spring-boot-starter-data-mongodb dependency
2. ```java 
      @Document, @Id, @DBRef(db = "chair") 
    ```
3. PagingAndSortingRepository
4. MongoRepository and it's parent classes
5. We can't query directly with sub-document properties in MongoRepository using methods like findByChairName ??
6. Spring Data Reactive Repository - Spring Boot 2.0 - Reactor - Non-blocking datasources like couchbase, mongo etc.
7. spring-boot-starter-data-mongodb-reactive, ReactiveCrudRepository
8. Mono(0,1) vs Flux(0,Many)

>### **Querying with spring data**
1. Property expression query methods - spring commons - BeanUtils & Reflections - Incorrect, we will get exception at app starting time instead of at run time.
   ```java
   findByAge(20)
   findByAttendeeLastName('prasad')
   findByFullTimeOrAgeLessThan(false,20)
   findByAgeGreaterThan(20)
   findByFullTimeOrAgeLessThan(true,20)
   findByAttendeeLastNameIgnoreCase('prasad')
   findByAttendeeLastNameLike('prasad')
   findFirstByOrderByAttendeeLastNameAsc()
   findTopByOrderByAgeDesc()
   findTop3ByOrderByAgeDesc()
   ```
2. @Query annotation - JPQL or SQL(nativeQuery=true) - Method names get too long, join queries - Even for native queries, the result will be mapped to resulting entity
  ```java
    @Query("select c from Course c where c.department.chair.member.lastName=:chair")
    List<Course> findByChairLastName(@Param("chair") String chairLastName);
    @Query("select c from Course c where c.department.chair.member.lastName= ?1")
    List<Course> findByChairLastName(String chairLastName);
  ```
3. Paging
  ```java
    public interface CourseRepository extends CrudRepository<Course,String>{
      Page<Course> findByCredits(int credits,Pageable pageable);
      List<Course> findByCredits(int credits);
    }
    courseRepository.findByCredits(3,PageRequest.of(0,4,Sort.Direction.ASC,"credits","name")); //Page includes list of courses, total number of entities, total number of page. page_number,page_size; getTotalElements, getTotalPages
  ```
  ```java
    public interface StaffRepository extends PagingAndSortingRepository<Staff,Integer>{
      Iterable<Staff> findAll(Sort sort);
      Page<Staff> findAll(Pageable pageable)
    }
    staffRepository.findAll(new Sort(Sort.Direction.ASC,"member.firstname"));
    staffRepository.findAll(PageRequest.of(0,5,new Sort(Sort.Direction.ASC,"member.lastname")));
  ```
4. Query by Example; JpaRepository<Department,Executor> -> QueryByExampleExecutor<Department>
  ```java
    departmentRepository.findOne(Example.of(new Department("Humanities",null)));//Find a department whose name was 'Humanities'
    departmentRepository.findAll(Example.of(new Department(null,new Staff(new Person("John",null))))); //Find all departments whose chair has the first name of 'John'
    departmentRepository.findAll(Example.of(new Department("sciences",null)),ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.ENDING));
  ```
5. Optional<> query response - Introduced in Spring Boot 2.0