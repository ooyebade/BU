package recursion;

import java.util.Stack;
public class hanoi {


    public static void main(String [] args)
    {
        tempStack<Integer> src = new tempStack<Integer>("Source");
        tempStack<Integer> spare = new tempStack<Integer>("Spare");
        tempStack<Integer> dest = new tempStack<Integer>("Dest");

        int num = 4;

        for(int i = 0; i < num;i++)
        {
            src.push(i);
        }

        System.out.println(solveTowers(num,src,spare,dest));
    }
    private static class tempStack<E> extends Stack<E>{
        public String name;
        public tempStack(String s)
        {
            super();
            this.name = s;
        }
    }
    //Base case move biggest thing to dest
    public static String solveTowers(int num,tempStack src, tempStack spare, tempStack dest)
    {
        String out ="";
        if(num==1) {

            Object o = src.pop();
            dest.push(o);

            out = "Moving " + o + " from " + src.name + " to " + dest.name + "\n";
        }
        else
        {
            out = solveTowers(num-1,src,dest,spare);
            Object o = src.pop();
            dest.push(o);
            out = out + " Moving " + o + " from " + src.name + " to " + dest.name + "\n";
            out += solveTowers(num-1,spare,src,dest);
        }

        return out;
    }
}
