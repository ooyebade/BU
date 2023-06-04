##Final Project

- Show the class diagram without considering any design patterns. Show the
  associations between the classes with navigability and multiplicity. Show the
  attributes and operations for the classes. 
- Implement the Java solution for the above making use of at least two creational
  patterns, at least two structural patterns, and at least two

#### Creational Patterns:
- The two creational pattern I used were the **Builder Pattern** and the **Simple Factory Pattern**. 
  - The **Builder Pattern** separates the construction of a complex object from its representation so that the
    same construction process can create different representations. 
    - My Builder class is *DBuilder* which specifies an abstract interface for creating parts of a Product object.
    - My Product class is *Department* which represents the complex object under construction.
    - My Concrete Builders class are *MasterBuilder*, *BachelorBuilder*, and *CertificateBuilder* which constructs and assembles parts of the product by extending the Builder interface.
    - My Builder Pattern does not have a *Director* class. 

  - The **Simple Factory Pattern** generates an instance of an object/service for client without exposing any implementation to the client.
    - The *Program* class is the product of the factory: defining it as an abstract class with helpful implementations.
    - *MastersProgram*, *BachelorProgram* and *CertificateProgram* are the Concrete products.
    - The *ProgramFactory* is where we create the programs, the only part of the application that refers to the concrete programs classes.
    - The *UnivProgram* is the client of the factory. 

### Structural Patterns: 
- The two structural patterns I used were the **Decorator Pattern** and **Facade Pattern**.
  - The **Decorator Pattern** attach additional responsibilities to an object dynamically and provide a flexible alternative to subclassing for extending functionality.
    - My Component is called *Semester* which is defining the interface for objects that can have responsibilities added to them dynamically.
    - My ConcreteComponents are called *FallSemester*, *SpringSemester* and *SummerSemester* which defines an object to which additional responsibilities can be attached.
    - My Decorator is *SemesterDecorator* which maintains a reference to a Component object and defines an interface that conforms to Component’s interface.
    - My ConcreteDecorators are *FallDecorator*, *SpringDecorator* and *SummerDecorator* which adds responsibilities to the component.

  - The **Facade Pattern** provide a unified interface to a set of interfaces in a subsystem and defines a higher level interface that makes the subsystem easier to use.
    - My Facade is *DepartmentFacade* which knows which subsystem classes are responsible for a request.
    - My Subclasses are *StudentEnrollment* and *CourseOffers* which implement subsystem functionality, and handle work assigned by the façade object.
    - I also added to class called *Course* and *Student*.
    
  ### Behavioral Patterns:
- The two behavioral patterns I used were the **Observer Pattern** and **State Pattern**.
  - The **Observer Pattern** defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
    - My *Subject* provides an interface for attaching and detaching my Observer objects.
    - My *Observer* defines an updating interface for objects that should be notified of changes in a subject.
    - My ConcreteSubject also known as *StudentSubject* stores state of interest to ConcreteObserver (*StudentObserver* and *CourseObserver*) objects and sends a notification to observers when its state changes.
    - My ConcreteObservers also known as *CourseObserver* and *StudentObserver* maintains a reference to a ConcreteSubject, stores state that should stay consistent with the subject’s, and implements the Observer updating interface to keep its state consistent with the subject’s.

  - The **State Pattern** allows an object to alter its behavior when its internal state changes.
    - My Context is called *CourseContext* defines the interface of interest to clients and maintains an instance of a ConcreteState subclass that defines the current state.
    - My State is called *CourseState* defines an interface for encapsulating the behavior associated with a particular state of the Context.
    - My ConcreteState subclasses are called *CourseEnrolled*, *CourseWaitlisted*, *TakingCourse*, and *NotTakingCourse* showing each subclass implements a behavior associated with a state of the Context.
