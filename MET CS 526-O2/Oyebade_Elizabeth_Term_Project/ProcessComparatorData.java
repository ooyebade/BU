import java.util.Comparator;

/**
 * This Method is implementing user-defined comparator...
 *      .... for the Data in the ArrayList based on the arrival time.
 * o1 --> the first process input object for comparison
 * o2 --> the second process input object for comparison
 * return 1, 0, or -1 based on whether process o1 has a lower, equal or greater arrival time
 *      ... than process o2
 */
public class ProcessComparatorData implements Comparator<Process> {
    @Override
    public int compare(Process o1, Process o2) {
        if (o1.getArrivalTime() > o2.getArrivalTime())
            return 1;
        else if (o1.getArrivalTime() < o2.getArrivalTime())
            return -1;
        return 0;
    }
}