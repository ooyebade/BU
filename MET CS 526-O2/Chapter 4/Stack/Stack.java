package Stack;

public interface Stack<E> {

    public String toString();
    public int size();
    public boolean empty();
    public E pop();
    public void push(E data);
    public E peek();
}
