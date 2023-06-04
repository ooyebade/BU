package Queue;

public class ArrayQueue<E> implements Queue<E> {

    private int f; //Front of the queue
    private int size; //Size of the queue
    private E[] arr; //Array

    public ArrayQueue(int capacity)
    {
        this.size = 0;
        this.arr = (E[]) new Object[capacity];
        this.f = 0;
    }
    public String toString()
    {
        if(this.size==0)
            return "";
        String out = "";
        for(int i = 0; i < this.size;i++)
        {
            int curr = (this.f + i) % this.arr.length;
            E element = this.arr[curr];
            out = out + element + ", ";
        }
        return out;
    }
    public int size(){return this.size;}
    public boolean isEmpty(){return this.size==0;}
    public E poll()
    {
        if(this.size==0) {
            return null;
        }
        else
        {
            E element = this.arr[this.f];
            this.f = (this.f + 1) % this.arr.length;
            this.size--;
            return element;
        }
    }
    public void offer(E data)
    {
        if(this.size==this.arr.length)
            throw new IllegalStateException("Queue is full");
        int index = (this.f + this.size) % this.arr.length;
        this.arr[index] = data;
        this.size++;
    }
    public E peek() {
        if(this.size >0)
        {
            return this.arr[this.f];
        }
        else return null;
    }
}
