import java.util.Comparator;

/**
 * This Method is implementing user-defined comparator...
 *      .... for the Queue based on the priority.
 * o1 --> the first process input object for comparison
 * o2 --> the second process input object for comparison
 * return 1, 0, or -1 based on whether process o1 has a lower, equal or greater priority than process o2
 */
public class ProcessComparatorQueue implements Comparator<Process> {
    @Override
    public int compare(Process o1, Process o2) {
        return Integer.valueOf(o1.getPri()).compareTo(Integer.valueOf(o2.getPri()));
        /**
         *if (o1.getPri() > o2.getPri())
         * return 1;
         * else if (o1.getPri() < o2.getPri())
         * return -1;
         * return 0;
         **/
    }
}


