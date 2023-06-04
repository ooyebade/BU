package oyebade.cs665.behavioral.observer;

import java.util.*;

public class StudentSubject implements Subject{

    private List<Observer> observers;

    private String s = "";

    public StudentSubject() {
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
            o.update(s);
        }
    }

    public void setValue(String s) {
        this.s = s;
        notifyObserver();
    }
}
