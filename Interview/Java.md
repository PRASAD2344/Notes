Object Oriented Programming
==============================================================================================
Extending 2 or More Interfaces
Function Overloading - Method with parameters object, number, integer - Runtime Error, CompileTime Error or will run
Anonymous Inner Class
Accessing outer class methods in Anonymous Inner Class
Compile time polymorphism
Access specifiers and Inheritance
Abstract class
Rules of Inheritance
Use of having Interface
Static vs Dynamic Binding

Queues
==============================================================================================
JMS vs Kafka
Kafka vs other messaging frameworks
Kafka at high level
Kafka client version
Kafka Message Size and limitations
How to send bulk messages in kafka
Kafka message format
Publish subscribe model and other models in detail

MicroService
==============================================================================================
Uses
Definition
12 Factor Principles
API Gateway
Config server
Consul discovery

Design Patterns
==============================================================================================
Singleton and thread save vs normal Implementation
Bypass Singleton pattern
Factory pattern

Serialization
==============================================================================================
Use of serialVersionUid and it's generation
Members that can't be serialized - transient and static final

REST Methods
==============================================================================================
PUT vs POST
HTTP Error Codes
HTTP Headers
Authentication vs Authorization
Http Response Codes

Programming
==============================================================================================
Convert char to Character

Memory Model
==============================================================================================
System.gc
Systems.gc vs RunTime.gc
Java Memory Model
Handling Out Of Memory Exception
ThreadDump
How will we analyse memory dump

Core Java
==============================================================================================
Immutability and Implementation
Exceptions Hierarchy
Exception Propagation
Custom Exception
throw vs throws
try behavior with no catch block, will exception thrown out
System.exit and finally block 
Enums
Co-Variant Return Type
Block level static variables
ClassNotFound Exception vs NoClassDef found exception
Class loading mechanism
Generics
Delegates
Reflection API
Volatile keyword
Comparable vs Comparator
How to invoke all methods of a class parallely

Collections
==============================================================================================
HashMap Implementation
HashMap table default size
Load Factor
hashCode and equals importance
Changing object which is a key in the middle and retrieving from map
HashMap vs ConcurrentHashMap, is hashmap synchronized
ArrayList Implementation
Default order of linkedhashset
Iterate Map
Iterator
Removing element while iterating and ConcurrentModificationException
ConcurrentCollections
SortedCollections
ArrayList vs LinkedList
DoubleLinkedList implemenation
isEmpty vs size methods in ArrayList
HashSet implemenation
HashTable implemenation
TreeSet implemenation
HashMap with null key
ConcurrentHashMap with null key
Linkedhashset vs hashset
Get me a collection which is ordered, thread safe and will not allow duplicates

Concurrency
==============================================================================================
ExecutorService and ThreadPool
ScheduledExecutorService
Process vs Thread
Runnable vs Callable vs Thread
ClassLevel Synchronization
Latches
Yield vs Wait vs Notify vs Join
CountdownLatch
Inter thread communication
Synchronized method vs synchornized block
Ways of creating thread pool
Static vs non static synchronised methods
Reentrant lock
Threadsafe collections vs Synchronous collections
Join vs Wait
Wait in synchornized block
How to avoid thread locks
Exception in Callable implemenation and how to get result from implemenation

Java 8
==============================================================================================
Optional Type
Lambdas
Streams
New Features and Date & Time API additions
Sorting using Java8
Flat Map example like Map<Key,List<>> to list
Interfaces vs Abstract classes in new release and how will they still differ

Java 7 & 9 & 11
==============================================================================================
New Features

SQL
==============================================================================================
Variouse JOINS
How can we anlayse Sql query and it's performance?
Join vs subquery, and which is best?
How index work?

Spring
==============================================================================================
IoC vs Dependency Injection
Loose Coupling - ??
Spring vs Spring Boot
Spring Boot vs Spring Cloud
Spring Components/Modules
Spring AOP
Spring IO
Spring MVC
Spring Security
Bean Scopes
ObjectMapper
Spring Profiles
Injecting Prototype bean into Singleton bean
@Component vs @Service vs @Repository
Prototype scope usage
Types of bean initialization
Why we are using spring boot for MicroService
Versions of cloud, boot
Lifecycle of a bean
Disabling autoconfiguration in spring boot
@SpringBootApplication
Access spring context, spring context aware
Ways to access json in rest controller

Basic Project Setup
Simple Controller Example
Spring Data Example
Spring Authentication Example
Spring Data Pagination Example
Spring REST Controller Global Error Handler
Spring REST File Upload Example
Custom Annotations Basic Example

Spring Web
==============================================================================================
Interceptor vs Filter
Request attribute vs Request parameter
Request parameter & path variable
View-Resolver
Message Converter - How spring will convert Objects into Response and Objects into Request
How will Message Converter help us in sending response in XML and JSON formats

Logs
==============================================================================================
Log4j vs sfl4j
Basic log configuration
Logback

JDBCTemplate
==============================================================================================
RowMapper vs ResultSetExtractor
update vs saveorupdate
preparedstatement vs statement
vs Hibernate

Misc
==============================================================================================
Test Driven Development
Webserver
Is functional programming a pattern or paradigm
Gradle vs Maven
Ehcache
JUnit
Fat JAR
How JVM works
JMeter
Soap vs REST
