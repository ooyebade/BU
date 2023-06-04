package oyebade.cs665.part1;

import java.util.*;

public class BankSubject implements Subject {

    private List<Observer> observers;

    private String value = "";

    public BankSubject() {
        observers = new ArrayList<>();
    }

    // using the add method to add the observer
    public void attach(Observer o) {
        observers.add(o);
    }

    // using the remove method to remove the observer
    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(value);
        }
    }

    public void setValue(String value) {
        this.value = value;
        notifyObserver();
    }
}
