
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

