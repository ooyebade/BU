package Queue;

public interface Queue<E> {
    public String toString();
    public int size();
    public boolean isEmpty();
    public E poll();
    public void offer(E data);
    public E peek();
}
