##Assignment 4

- Continuation of Assignment 3
- Consider the **structural patterns** for this assignment. For each of the problems
  below, identify the patterns and show the class structure when the pattern is
  applied and provide justification. Write the Java implementation for the classes
  and provide the test results.

#### Part 1:
- The transactions for each account could be simple transactions, or transactions
  with logging capability, security capability, or a combination of any of these or
  more in the future.
  - The structural pattern used for part 1 is the **Decorator Pattern.**
  - The Decorator pattern intent is to attach additional responsibilities to an object dynamically and provide a flexible alternative to subclassing for extending functionality
  - My Component is called **Transaction** which is defining the interface for objects that can have responsibilities added to them dynamically.
  - My two ConcreteComponent are called **DepositTransaction** and **WithdrawTransaction** which defines an object to which additional responsibilities can be attached.
  - My Decorator is **TransactionDecorator** which maintains a reference to a Component object and defines an interface that conforms to Component’s interface
  - My two ConcreteDecorator are **LoggingDecorator** and **SecurityDecorator** which adds responsibilities to the component



### Part 2:
- The bank would like to provide statements to the customer. These could be
  monthly statements, quarterly statements, half-yearly, full year, or multi-year
  statements. Each higher level statement would recursively include its
  component statements.
  - The structural patter used for part 2 is the **Composite Pattern**.
  - The Composite Pattern intent is to compose objects into tree structures to represent part-whole hierarchies
  - My Component is called **Statement** which is declaring the interface for objects in the composition, implementing default behavior for the interface common to all classes and declaring an interface for managing and accessing its child components.
  - My Leaf is called **MonthlyStatement** and which is representing leaf objects in the composition and defining behavior for primitive objects in the composition.
  - My Composite is called **ComboStatement** which is defining behavior for components having children, storing child components and implementing child-related operations in the Component interface.


### Part 3:
- The bank uses an external package for customer verification. These packages
  and its interfaces could change in the future.
  - The structural pattern for part is the **Adapter Pattern**
  - The Adapter Pattern intent is to convert the interface of a class into another interface clients expect.
  