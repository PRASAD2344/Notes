
Design patterns are general solutions to common Object Oriented Problems
It's about object creation and interactions

Creational - Creation, Initialization and Class selection
Structural - Relationships and combining
Behavioral - Interactions between objects

Abstract Factory, Builder, Factory Method, Prototype, `Singleton` - Creational
Adapter, Bridge, Composite, `Decorator`, `Facade`, Flyweight, Proxy - Structural
Command, Interpreter, Iterator, Mediator, Memento, Chain Of Responsibiliy, Template Method, Visitor, `Observer`, Strategy, State - Behavioral

java.util.Observer, java.util.Observable - Observer patterns
System.console, Runtime.getRuntime - Singleton patterns
java.util.Comparator - Strategy pattern

Enable patterns with annotations
Relies on CDI(Contexts and Dependency Injection), Interceptors, and EJB

Singleton pattern
https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/
Single object in JVM - Shared instance in JVM
Construct heavy objects like connection pools
To have it - Double-check lockings, Private Consructors, Nested Synchronizations but still not thread safe
Java EE offers elegant solutions
Container managed concurrency
Convention over configuration
Lazily Instanitiated Singleton
Read locked by default
@Singleton, @Startup, @PostConstruct, @DependsOn
Singleton Pattern Concurrency
Java EE provides Container Managed Concurrency and Bean Manager Concurrency
@ConcurrencyManagement - BEAN, CONTAINER(Default)
@Lock - LockType.READ, LocakType.WRITE
@AccessTimeOut(value = 30, unit = TimeUnit.SECONDS)

Facade Pattern
Unified Interface To Subsystem
REST is one example
@EJB, @Stateful(stored on disk), @StateLess
EJB is thread safe by default and contains pool
All EJB interactions were wrapped around transactions by default

Decorator Pattern
Dynamically add a behavior at run time
Example: java.io.BufferedInputStream
More flexible than inheritances
@Decorator, @Delegate, @Any, @Priority
Logger scenario - Customize third party logger api
@Qualifier, @Retention, @Target

Monolithic and Microservice Architecture


CQRS Architecture
Command Query Responsibility Segregation
Command That Performs An Action But No Return
Query That Returns Data But No Operation
Not Always Desirable - Stack pop & DB Update and returning updated record
Single DB Structure
Two DB Structure - Eventual Consistency - Much more performance
Event-sourcing Structure - Event Store - Banking Systems - Event Logs
Advantages - 
Avoid hidden side effects
Fits the domain-centric model
Optimized for the operation they need to peform i.e., Read & Write
Disadvantages -
Complex and difficult of maintain as we have different design on different tracks
More expensive as we need to maintain different data stores, event stores and stacks

Screaming Architecture
Domain Centric
New Developer will get up to speed in less time
Instead of Controller, View, Model, View, and Mobile folders we will have Customer, Employees, Inventory, Sales etc folders
Make the intent obvious, based around functional requirements rather than technical requirements
Hides the intent of application
Logical Cohesive vs Functional Cohesive
Disadvantages - 
Loose convention to configuration which were required for IDE's we need some manual configuration
Lose some automation
More expensive at first, as we have some configurations to add

Domain centric Architecture


Database centric Architecture


