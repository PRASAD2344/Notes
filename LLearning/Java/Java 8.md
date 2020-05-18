[Reference](https://www.linkedin.com/learning/learning-java-lambda-expressions)

>### **Functional Interfaces**
1. java.util.function added in java 8
2. java.util.stream added in java 8
3. @FunctionalInterface
3. Predicate - takes one argument, return boolean
   ```java
   Predicate<String> stringLen = (s) -> s.length() < 10;
   System.out.println(stringLen.test("Apples") + " - Apples is less than 10");
   ```
4. Consumer -takes one argument, no return value
   ```java
   Consumer<String> printLine = (s) -> System.out.println(s);
   printLine.accept("My Dog!!");

   //example of a lambda made from an instance method
   Consumer<String> printLine = System.out::println;
   printLine.accept("My Dog!!");
   ```
5. Function - take one argument and produces a result
   ```java
   Function<Integer,String> stringConverter = (num) -> Integer.toString(num);
   System.out.println("length of 26: " + stringConverter.apply(26).length());

   //static method reference using ::
   Function<Integer,String> intToString = Integer::toString;
   System.out.println("length of 32 " + intToString.apply(32).length());

   //Lambda's made using a constructor
   Function<String,BigInteger> newBigInt = BigInteger::new;
   BigInteger sample = newBigInt.apply("12121212112");

   ```
6. Supplier - represents a supplier of results
   ```java
   Supplier<String> supplier = () -> "Java if fun";
   System.out.println(supplier.get());
   ```
7. UnaryOperator - single argument with a return value
   ```java
   UnaryOperator<String> toLowerCase = (msg) -> msg.toLowerCase();
   System.out.println(toLowerCase.apply("This should be in lower case."));
   ```
8. BinaryOperator - two arguments, with a return value
   ```java
   BinaryOperator<Integer> add = (a,b) -> a + b;
   System.out.println("add 10 + 25 : " + add.apply(10,25));
   ```
9. 

>### **Collections**
1. Introduced with Java 7
2. Arrays.asList
3. Collections.sort
   ```java
   Collections.sort(names,new Comparator<String>() {
     @Override
     public int compare(String a,String b){
       return b.compareTo(a);
     }
   });
   Collections.sort(names,(a,b) -> b.compareTo(a));
   ```
4. Given list of books, caluculate total number of pages ?
5. Given list of books, caluculate list of authors?
6. Given list of books, remove duplicates using set
