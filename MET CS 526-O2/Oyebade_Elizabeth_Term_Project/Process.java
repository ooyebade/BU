/**
 * @author Elizabeth Oyebade
 * course MET CS 526-O2
 * date 04/26/2022
 * Term Project
 */

/**
 * Creating a process class that represents the processes
 */
public class Process {

    // Each process will have an id, priority, duration and arrival time
    private int id; // Process ID
    private int pri; // Priority of the process
    private int dur; // The amount of time it's going to take to completely execute the process
    private int arrivalTime; // The time when the process arrives at the system
    private int waitTime; // Keeps track of the wait in the priority queue

    // Setting the default values to an empty Process
    public Process() {}

    // Setting the values with a constructor
    public Process(int id, int pri, int dur, int arrivalTime, int waitTime) {
        this.id = id;
        this.pri = pri;
        this.dur = dur;
        this.arrivalTime = arrivalTime;
        this.waitTime = waitTime;
    }

    // Getting each of the process value (Accessor Method)
    public int getId() { return id; }
    public int getPri() { return pri; }
    public int getDur() { return dur; }
    public int getArrivalTime() { return arrivalTime; }
    public double getWaitTime() { return waitTime; }

    // Setting each of the process value
    public void setId(int id) { this.id = id; }
    public void setPri(int pri) { this.pri = pri; }
    public void setDur(int dur) { this.dur = dur; }
    public void setArrivalTime(int arrivalTime) { this.arrivalTime = arrivalTime; }


    /**
     * Method used to set wait time according to its parameter
     * @param waitT the calculated wait time of the process
     */
    public void setWaitTime(int waitT) { waitTime = waitT; }

    // Method used to update the priority by decreasing the priority by 1
    public void updatePri() { pri = pri - 1; }
}