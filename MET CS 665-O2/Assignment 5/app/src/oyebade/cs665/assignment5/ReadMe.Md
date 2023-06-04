##Assignment 5

- Continuation of Assignment 4
- Consider the behavioral patterns for this assignment. For each of the problems
  below, identify the patterns and show the class structure when the pattern is
  applied and provide justification. Write the Java implementation for the classes
  and provide the test results.

#### Part 1:
- Each bank would like to provide alerts (new products, change in interest rate,
  etc.) to its customers. Instead of sending alerts to all customers, the bank
  provides a mechanism to let interested customers register themselves. The bank
  would like to send alerts to registered customers as and when necessary.
  - The behavioral pattern used for part 1 is the **Observer Pattern.**
  - The Observer pattern intent is to define a one-to-many dependency between objects so that when one object
  changes state, all its dependents are notified and updated automatically.
  - My **Subject** provides an interface for attaching and detaching my Observer objects.
  - My **Observer** defines an updating interface for objects that should be notified of changes in a subject.
  - My ConcreteSubject also known as **BankSubject** stores state of interest to ConcreteObserver (*BankObserver*) objects and sends a notification to observers when its state changes.
  - My ConcreteObserver also known as **BankObserver** maintains a reference to a ConcreteSubject, stores state that should stay consistent with the subject’s, and implements the Observer updating interface to keep its state consistent with the subject’s.



### Part 2:
- Each bank has different ways of calculating the interest amount for the savings
  account (e.g., simple interest at the end of each month, interest compounded
  daily, etc.).
  - The behavioral pattern used for part 2 is the **Strategy Pattern**.
  - The Strategy Pattern intent is to define a family of algorithms, encapsulate each one, and make them
    interchangeable
  - My Strategy is called **CalculateInterest** which is declaring an interface common to all supported algorithms.
  - My two ConcreteStrategy are called **SimpleInterest** and **CompoundedInterest** each implementing the algorithm using the Strategy interface. And each returning their own formula.
  - My Context is called **SavingsAccount** which maintains a reference to the Strategy (*CalculateInterest*) object.