import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Elizabeth Oyebade
 * course MET CS 526-O2
 * date 04/26/2022
 * Term Project
 */

public class ProcessScheduling {

    public static void main(String[] args) throws Exception {

        // creating a file object that will be passed to the file that will be written too
        PrintWriter outputFile = new PrintWriter("process_scheduling_output.txt");

        // creating an empty ArrayList for storing the process object that's been read
        ArrayList<Process> dataProcess = new ArrayList<>();

        // passing the path to the file that will be read from
        File inputFile = new File("process_scheduling_input.txt");
        Scanner scanner = new Scanner(inputFile);

        // While file has next line...iterate till the end
        while (scanner.hasNextLine()) {
            // then get the integers that'll correspond to each part of the process
            int id = scanner.nextInt();
            int pri = scanner.nextInt();
            int dur = scanner.nextInt();
            int arrivalTime = scanner.nextInt();
            int waitTime = 0;

            // create new processes object
            Process process = new Process(id, pri, dur, arrivalTime, waitTime);
            // add into the ArrayList to return
            dataProcess.add(process);
        }
        // close scanner
        scanner.close();

        // sorting the ArrayList
        Collections.sort(dataProcess, new ProcessComparatorData());
        //Collections.sort(Data, new ProcessComparatorData());

        // write and print all the process detail info into p
        for (Process p: dataProcess) {
            outputFile.println(
                    "Id = " + p.getId() + ", Priority = " + p.getPri() +
                            ", Duration = " + p.getDur() + ", Arrival Time = " + p.getArrivalTime()
            );
        }

        // instance of the process
        Process processRun = new Process();

        // maximum wait time
        int maxWaitTime = 30;

        // default maximum wait time is 30...printing out the wait time
        outputFile.println("\nMaximum wait time = " + maxWaitTime + "\n");

        // create an empty priority queue (Q)
        PriorityQueue<Process> processPriorityQueue = new PriorityQueue<>(new ProcessComparatorQueue());

        // initializing the current time of the stimulation to 0
        int currentTime = 0;
        // indicates whether the system is currently executing a process or not
        boolean running = false;
        // keeping track of the wait times and average wait time
        ArrayList<Integer> waitTimeArray = new ArrayList<>();
        // whenever the process is removed from the priority queue (to be executed)
        int startTime = 0;
        // whenever the process execution time finishes
        int endTime = 0;

        // Iteration of the while loop represents what occurs during one time unit
        // Increment currentTime in each iteration
        // while loop runs once for every time unit until Data is empty
        while(dataProcess.size() != 0) {
            // Get (don't remove) a process p from Data that has the earliest arrival time
            Process p = dataProcess.get(0);
            // If the arrival time of p is less than currentTime
            if (p.getArrivalTime() <= currentTime) {
                // Remove p from Data and insert it into Queue
                dataProcess.remove(p);
                processPriorityQueue.add(p);
            }

            // If Queue is not empty and the flag running is false
            if (processPriorityQueue.size() != 0 && !running) {
                // Remove a process with the smallest priority from Queue
                processRun = processPriorityQueue.poll();
                // Set the start time to current time to mark for when the process is...
                    // ...removed from the queue
                startTime = currentTime;
                // Calculate the process of the wait time
                int waitTime = QueueOpr.waitUpdate(processRun, startTime);
                // Set a flag running to true
                running = true;
                // Then add the wait time to the array
                waitTimeArray.add(waitTime);
                // output file
                outputFile.println(QueueOpr.printR(processRun, startTime, waitTimeArray));
            }

            endTime = startTime + processRun.getDur(); // time process finish after execution calculation

            // If currently running process has finished
            if (currentTime !=0 && currentTime == endTime) {
                running = false; // set a flag running to false
                // output file
                outputFile.println(QueueOpr.printF(processRun, endTime));
                // update priorities to process that have been waiting longer than max wait time
                QueueOpr.updatePri(processPriorityQueue, maxWaitTime, endTime, outputFile);
                // set current time to end time
                currentTime = endTime;
            } else {
                // increment current time
                currentTime += 1;
            }
        }

        // print data
        outputFile.println("(D) becomes empty at time " + (currentTime - 1) + "\n");

        // now reset the loop
        currentTime = endTime;
        running = false;

        QueueOpr.updatePri(processPriorityQueue, maxWaitTime, currentTime, outputFile);

        // while the queue is empty
        while (processPriorityQueue.size() != 0) {
            // if running flag is false
            if (!running) {
                // Remove a process with the smallest priority from Queue
                processRun = processPriorityQueue.poll();
                // Set the start time to current time to mark for when the process is...
                // ...removed from the queue
                startTime = currentTime;
                // Calculate the process of the wait time
                int waitTime = QueueOpr.waitUpdate(processRun, startTime);
                // Set a flag running to true
                running = true;
                // Then add the wait time to the array
                waitTimeArray.add(waitTime);
                // output file
                outputFile.println(QueueOpr.printR(processRun, startTime, waitTimeArray));
            }

            endTime = startTime + processRun.getDur(); // time process finish after execution calculation

            // If currently running process has finished
            if (currentTime == endTime) {
                running = false; // set a flag running to false
                // output file
                outputFile.println(QueueOpr.printF(processRun, endTime));
                // update priorities to process that have been waiting longer than max wait time
                QueueOpr.updatePri(processPriorityQueue, maxWaitTime, endTime, outputFile);
                // set current time to end time
                currentTime = endTime;
            } else {
                // increment current time
                currentTime++;
            }
        }

        // calculate the average wait time
        double totalWTime = QueueOpr.totalWaitTime(waitTimeArray);
        double avgWaitTime = totalWTime / waitTimeArray.size();

        // output file
        outputFile.println(
                "Total wait time = " + totalWTime + "\n" +
                        "Average wait time = " + avgWaitTime
        );
        outputFile.close();
    }
}