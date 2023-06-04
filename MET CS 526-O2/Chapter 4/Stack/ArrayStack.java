package Stack;

public class ArrayStack<E> implements Stack<E> {

    private E [] arr;
    private int t; //index of the top of the stack
    private final static int DEFAULT_CAPACITY = 100;

    public ArrayStack(int capacity)
    {
        arr = (E[]) new Object[capacity];
        t = -1;
    }

    public String toString()
    {
        String out = "";
        int count = t;
        while(count>=0)
        {
            E curr = this.arr[count];
            out += curr + ", ";
            count--;
        }
        return out;
    }
    public int size(){return t+1;}
    public boolean empty(){return this.size()==0;}
    public E pop()
    {
        if(t==-1)
        {
            return null;
        }else
        {
            E data = this.arr[t];
            t--;
            return data;

        }
    }
    public void push(E data)
    {
        if(t == arr.length-1)
        {
            throw new IndexOutOfBoundsException("Stack is full");
        } else
        {
            t++;
            arr[t] = data;
        }

    }
    public E peek(){
        if(t==-1)
        {
            return null;
        }else
        {
            return this.arr[t];
        }
    }


}
