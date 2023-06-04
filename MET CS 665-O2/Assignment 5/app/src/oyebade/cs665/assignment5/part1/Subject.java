package oyebade.cs665.part1;

public interface Subject {
    // registering the observer
    public void attach(Observer o);
    // removing the observer
    public void detach(Observer o);
    // notifying observer
    public void notifyObserver();
}
