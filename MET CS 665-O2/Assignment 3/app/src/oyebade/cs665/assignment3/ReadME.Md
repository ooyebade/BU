##Assignment 3

- Continuation of Assignment 2
- You want your bank application to be generic enough and be able to satisfy the
  needs of all the banks with as few changes as possible. Consider the creational
  patterns for this assignment. For each of the problems below, identify the
  patterns and show the class structure when the pattern is applied and provide
  justification. Write the Java implementation for the classes and provide the test
  results.

#### Part 1: 
- The creational pattern used for part 1 is the **Abstract Factory Pattern.**
- The Abstract Factory Pattern intent is to provide an interface for creating families of 
related or dependent objects without specifying their concrete classes. But within my 
abstract factory pattern, I did not use an interface, instead I 
implemented an abstract class for the Account, which then extended 
the *Account* class to the **CheckingAccount** and **SavingsAccount** class.
Hence, allowing the two different banks to return its required Checking and Savings Account
output.
- My AbstractFactory is called **AccountFactory** which is declaring the CheckingAccount and
SavingsAccount class for operations that will create the abstract product objects.
- My two ConcreteFactory are called **BankOfAmericaFactory** and 
**NavyFederalCreditUnionFactory** which extends the operations to create concrete product objects. 
- My two AbstractProduct are **CheckingAccount** and **SavingsAccount** which is
declaring the abstract class *Account* for a type of product object.
- My two ConcreteProduct are **BankOfAmerica** and **NavyFederalCreditUnion** which is 
Defining the product object to be created by the corresponding concrete factory.



### Part 2:
- The creational patter used for part 2 is the **Builder Pattern**.
- The Builder Pattern intent is to separate the construction of a complex object from its representation so that the
  same construction process can create different representations.
- My Builder is called **BankBuilder** which is specifying the abstract interface for creating parts of the Product object 
also known as *UserInterface*.
- My ConcreteBuilders are called **BankOfAmericaBuilder** and
**NavyFederalCreditUnionBuilder** which is constructing and 
assembling parts of the product by implementing 
the BankBuilder interface. Then defining and keeping track of the representation it creates. And finally, providing
an interface for retrieving the product. 
- My Director is called **BankDirector** which constructs the objects using the BankBuilder interface. 
- My Product is called **UserInterface**: 
  - Represents the complex object under construction.
  - The ConcreteBuilders builds the product’s internal representation and defines the process by which it is
  assembled.


### Part 3: 
- Two creational patterns were used for part 3, and they are called: SimpleFactory and FactoryMethod. 

- SimpleFactory: 
  - Generates an instance of an object/service for client without exposing any implementation to the client.

- FactoryMethod:
  - Intent: Define an interface for creating an object, but let subclasses decide which class to instantiate.