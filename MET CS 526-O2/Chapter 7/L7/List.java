package L7;

public interface List<E> {
    public int size();
    public boolean isEmpty();
    public E get(int i);
    public void set(int i, E data);
    public E remove(int i);
    public void add (int i, E data);


}