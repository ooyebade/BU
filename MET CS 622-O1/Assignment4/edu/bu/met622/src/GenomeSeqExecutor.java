package edu.bu.met622.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Elizabeth Oyebade
 * 06.14.2022
 * MET CS 622-01
 * Assignment 4
 *
 * The purpose of this program is to first create a program that creates 100 random
 * genome sequence each should be 10 character long, e.g. ATGGCAACAG, CAACATCAGC, TTCTCTGTTT.
 * Then, after creating the program, use concurrency to make the program faster (use five threads to create
 * 20 genome sequence each).
 * And lastly comparing the differences between single thread and multithread run
 */

public class GenomeSeqExecutor {

    /**
     * This method is being used to generate the genome sequences randomly
     * @return a random String of the genomeLength comprised of the 4 characters "ATGC"
     */
    public static String randomGenomeSequences() {
        // generates random objects
        Random rand = new Random();
        // setting the capacity of the sequence length
        int genomeLength = 10;
        // using the StringBuilder with the dnaLength
        StringBuilder sequence = new StringBuilder(genomeLength);
        // iterating through the capacity
        for(int i = 0; i < genomeLength; i++) {
            // using the switch statement to append the random string among the 4 characters
            switch(rand.nextInt(4)) {
                case 0:
                    sequence.append("A");
                    break;
                case 1:
                    sequence.append("T");
                    break;
                case 2:
                    sequence.append("G");
                    break;
                case 3:
                    sequence.append("C");
                    break;
            }
        }
        //
        return sequence.toString();
    }

    /**
     * This method is being executed to manage single thread method and add 100 random entries to the list.
     * @return the total time of single thread in ms.
     */
    private static double singleThread() {
        // declare the list of the string types
        List<String> genomeSequence = new ArrayList<>();
        // calculate the execution time for single thread
        long singleStartTime = System.currentTimeMillis();
        // print the start time of the single thread

        // iterating through the numbers of entries then generate the random genome length
        for(int i = 0; i < 100; i++) {
            genomeSequence.add(randomGenomeSequences());
        }

        // printing each string shown in the list
        for(String string : genomeSequence) {
            // system prints out the string
            System.out.println(string);
        }

        // calculate the end time for single thread
        long singleEndTime = System.currentTimeMillis();
        // calculate the total time taken for the single thread to be completed
        long singleTotalTime = singleEndTime - singleStartTime;
        // system print of the total time for single thread in ms
        System.out.println("Total Time using single threaded method is: " + singleTotalTime + " milliseconds");
        // returning the total time for the single thread method
        return singleEndTime - singleStartTime;
    }

    /**
     * This method is being executed to manage multi thread method and add 20 random entries to the list.
     */
    private static void multiThread() {
        // declare the list of the string types
        List<String> genomeSequence = new ArrayList<>();
        // iterating through the numbers of entries then generate the random genome length
        for(int i = 0; i < 20; i++) {
            genomeSequence.add(randomGenomeSequences());
        }

        // printing each string shown in the list
        for(String string : genomeSequence) {
            // system prints out the string
            System.out.println(string);
        }
    }

    /**
     * Thread thread1 = new Thread();
     * Thread thread2 = new Thread();
     * Thread thread3 = new Thread();
     * Thread thread4 = new Thread();
     * Thread thread5 = new Thread();
     **/

    public static void main(String[] args) {
        // execute single thread method
        double singleThreadEndTime = singleThread();
        // creating a thread array
        Thread[] threads = new Thread[5];

        // iterating through the loop array
        for(int i = 0; i < 5; i++) {
            // creating a thread array to run the multi thread method
            threads[i] = new Thread(GenomeSeqExecutor::multiThread);
        }

        // calculate the execution time for multi thread
        long multiStartTime = System.currentTimeMillis();

        // looping through all threads
        for(Thread thread: threads) {
            // starting each threads in the loop
            thread.start();
        }

        // iterating through thread
        for (Thread thread: threads) {
            // using try-catch block to handle exceptions
            try {
                // join allows the calling thread to wait till another thread is done
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        // calculate the end time for multi thread
        long multiEndTime = System.currentTimeMillis();
        // calculate the total time taken for the single thread to be completed
        long multiTotalTime = multiEndTime - multiStartTime;
        // system print of the total time for multi thread in ms
        System.out.println("Total Time using multi threaded method is: " + multiTotalTime + " milliseconds");

        // print the differences result between single thread and multi-thread
        if(singleThreadEndTime > multiTotalTime) {
            System.out.println("Single Thread method took longer to finish");
        } else if (singleThreadEndTime < multiTotalTime) {
            System.out.println("Multi Thread method took longer to finish");
        } else {
            System.out.println("No significant difference between single and multi thread found");
        }
    }
}