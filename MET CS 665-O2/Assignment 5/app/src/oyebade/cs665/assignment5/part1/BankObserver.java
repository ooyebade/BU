package oyebade.cs665.part1;

public class BankObserver implements Observer{

    // instance variables
    // observer value
    private String value;
    // observer name
    private String name;

   //private Subject bankSubject;

    public BankObserver(String name) { //, Subject bankSubject)
        this.name = name;
        /* this.bankSubject = bankSubject;
        bankSubject.attach(this); */
    }

    public void update(String value) {
        this.value = value;
        display();
    }

    public void display() {
        System.out.println("Message received by " + name + ": " + value);
    }
}
