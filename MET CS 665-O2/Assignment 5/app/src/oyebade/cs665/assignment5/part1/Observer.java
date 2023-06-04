package oyebade.cs665.part1;

public interface Observer {
    // defining an update interface for objects that should be notified of changes in the subject
    public void update(String value);
}
