package oyebade.cs665.behavioral.observer;

public interface Subject {

    // registering the observer
    void attach(Observer o);
    // removing the observer
    void detach(Observer o);
    // notifying observer
    void notifyObserver();
}
