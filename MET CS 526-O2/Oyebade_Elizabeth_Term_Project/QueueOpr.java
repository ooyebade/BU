import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class QueueOpr {

    /**
     * Calculating the total wait time of processes removed from queue
     * @param waitTimeArray keeps track of the wait time that's removed from the queue in the array
     * @return total wait time
     */
    public static int totalWaitTime(ArrayList<Integer> waitTimeArray) {
        int totalWaitTime = 0;
        for (int i: waitTimeArray) {
            totalWaitTime += i;
        }
        return totalWaitTime;
    }

    /**
     * Printing the process that's removed from the queue to the output text file
     * @param p removed process
     * @param startTime when it's removed
     * @param waitTimeArray keeps track of the wait time that's removed from the queue in the array
     * @return the output
     */
    public static String printR(Process p, int startTime, ArrayList<Integer> waitTimeArray) {
        // adding the wait time to total up to the time
        int totalWaitTime = totalWaitTime(waitTimeArray);
        String indOutput =
                "Priority = " + p.getPri() + "\n" +
                        "Arrival = " + p.getArrivalTime() + "\n" +
                        "Duration = " + p.getDur() +  "\n";

        String fOutput = "Process removed from queue is: id = " + p.getId() +
                ", at time " + startTime +
                ", wait time = " + p.getWaitTime() +
                " Total wait time = " + totalWaitTime +
                "\n" + "Process id = " + p.getId() +
                "\n" +
                indOutput.indent(5);
        return fOutput;
    }

    /**
     * Printing the finished execution process to the output text file
     * @param p removed process
     * @param endTime execution finished time
     * @return output
     */
    public static String printF(Process p, int endTime) {
        String output = "Process " + p.getId() +
                " finished at time " + endTime + "\n" +
                "\n" +
                "Update priority: ";
        return output;
    }

    /**
     * Printing the updated priority process to the output text file
     * @param p updated process
     * @return output
     */
    public static String printPriority(Process p) {
        String output = "PID = " + p.getId() +
                ", wait time = " + p.getWaitTime() +
                ", current priority = " + (p.getPri() + 1) + "\n" +
                "PID = " + p.getId() +
                ", new priority = " + p.getPri() + "\n";
        return output;
    }

    /**
     *
     * @param Queue process priority queue
     * @param maxWaitTime wait time maximum
     * @param endTime updated priority end time
     * @param outputFile storing the printed output file
     */
    public static void updatePri(PriorityQueue<Process> Queue, int maxWaitTime, int endTime, PrintWriter outputFile) {
        ArrayList<Process> tempArr = new ArrayList<>();
        for (Process process : Queue) {
            waitUpdate(process, endTime);
            if(process.getWaitTime() >= maxWaitTime) {
                process.updatePri();
                // output file
                outputFile.println(printPriority(process));
                tempArr.add(process);
            }
        }

        for(Process p : tempArr) {
            Queue.remove(p);
            Queue.add(p);
        }
    }

    /**
     *
     * @param p updated process
     * @param updatedTime updated time
     * @return wait time
     */
    public static int waitUpdate(Process p, int updatedTime) {
        int waitTime = updatedTime - p.getArrivalTime();
        p.setWaitTime(waitTime);
        return waitTime;
    }
}