import java.util.Random;
/**
 * @author: Elizabeth Oyebade
 * course: MET CS 526-O2
 * date: 04/19/2022
 *
 * Sorting Algorithms with an elapsed time comparison for 10 different sizes
 *      using insertion-sort, merge-sort, quick-sort and heap-sort.
 *
 * Then the program should generate n random integers between 1 and 1,000,000
 */
public class Hw5_p7 {
    public static void main(String[] args) {
        Random r = new Random();
        int index = 0;
        int d[], c[], b[];

        // storing the values of the elapsed times in the array
        long[] insertionSortElapsedTime = new long[10];
        long[] mergeSortElapsedTime = new long[10];
        long[] quickSortElapsedTime = new long[10];
        long[] heapSortElapsedTime = new long[10];

        // initializing the first length of numbers
        int n = 10000;

        // declare variables
        // start time
        long startTime;
        // end time
        long endTime;
        // elapsed time
        long elapsedTime;

        // sizes of array for each execution
        // int[] arraySizes = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};

        while (n <= 100000) {
            // creating a length of array to store the array values
            int array[] = new int[n];
            // generating random integers for each size between 1 and 1,000,000 into the array
            for (int i = 0; i < n; i++) {
                array[i] = r.nextInt(1000000) + 1;
            }

            // creating copies
            b = array.clone();
            c = array.clone();
            d = array.clone();

            // elapsed time for insertion sort
            startTime = System.currentTimeMillis();
            insertionSort(array);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            // then store the value in the array
            insertionSortElapsedTime[index] = elapsedTime;

            // elapsed time for merge sort
            startTime = System.currentTimeMillis();
            mergeSort(b, b.length);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            // then store the value in the array
            mergeSortElapsedTime[index] = elapsedTime;

            // elapsed time for quick sort
            startTime = System.currentTimeMillis();
            quickSort(c, 0, c.length - 1);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            // then store the value in the array
            quickSortElapsedTime[index] = elapsedTime;

            // elapsed time for heap sort
            startTime = System.currentTimeMillis();
            heapSort(d);
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            // then store the value in the array
            heapSortElapsedTime[index] = elapsedTime;
            // incrementing the index
            index++;
            // incrementing the value n
            n = n + 10000;
        }

        // table format
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("\nn\t\t10000 \t20000 \t30000 \t40000 \t50000 \t60000 \t70000 \t80000 \t90000 \t1000000");
        System.out.println("Algorithm");
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.print("Insertion\t");
        for(long i : insertionSortElapsedTime) {
            System.out.print(i + "\t");
        }

        System.out.println();
        System.out.print("Merge\t");
        for(long i : mergeSortElapsedTime) {
            System.out.print(i + "\t");
        }

        System.out.println();
        System.out.print("Quick\t");
        for(long i : quickSortElapsedTime) {
            System.out.print(i + "\t");
        }

        System.out.println();
        System.out.print("Heap\t");
        for(long i : heapSortElapsedTime) {
            System.out.print(i + "\t");
        }

        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
    }

    /**
     * Method is using the insertion sort alg to sort out the array
     * @param array: as an array of pseudo-random integer
     */
    // Insertion Sort
    public static void insertionSort(int[] array) {
        // Iterating over integer array
        for (int i = 0; i < array.length; i++) {
            // set the current integer
            int key = array[i];
            // comparing the current element
            int j = i - 1;
            // move elements that are greater than the key to one position ahead of the current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    /**
     *
     * @param array of integers
     * @param n positions in the array
     */
    public static void mergeSort(int[] array, int n) {
        if (n < 2)
            return;
            // find the middle point
            int mid = n / 2;
            int[] l = new int[mid];
            int[] r = new int[n - mid];

            for(int i = 0; i < mid; i++) {
                l[i] = array[i];
            }

            for(int i = mid; i < n; i++) {
                r[i - mid] = array[i];
            }
            // sort the first and second halves
            mergeSort(l, mid);
            mergeSort(r, n - mid);
            // merge the two sorted halves
            merge(array, l, r, mid, n - mid);
    }


    public static void merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k++] = l[i++];
            }
            else {
                array[k++] = r[j++];
            }
        }
        // copying remaining left element
        while (i < left) {
            array[k++] = l[i++];
        }
        // copying remaining right element
        while (j < right) {
            array[k++] = r[j++];
        }
    }

    /**
     * Method is find the partition index
     * @param array of integers
     * @param low positions as an argument
     * @param high positions as an argument
     * @return the int
     */
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        // index of the smaller element
        int i = low - 1;
        for (int j = low; j < high; j++) {
            // if the current element is smaller than the pivot
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    /**
     * This method is using the quickSort alg
     * @param array of integers
     * @param low positions as an argument
     * @param high positions as an argument
     */
    public static void quickSort(int[] array, int low, int high) {
        if(low < high) {
            int part = partition(array, low, high);
            quickSort(array, low, part - 1);
            quickSort(array, part + 1, high);
        }
    }


    /**
     * Method allows to sort array using heapSort alg
     * @param array of integers as an argument
     */
    // Heap Sort
    public static void heapSort(int[] array) {
        int n = array.length;
        // build max leap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract an element from heap
        for(int i = n - 1; i >= 0; i--) {
            // move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int n, int i) {
        // Initialize the largest as root
        int largest = i;
        // left = 2*i + 1
        int left = 2 * i + 1;
        // right = 2*i+2
        int right = 2 * i + 2;
        // If left child is larger than the root
        if(left < n && array[left] > array[largest]) {
            largest = left;
        }
        // If right child is larger than the largest
        if(right < n && array[right] > array[largest]) {
            largest = right;
        }
        // if largest is not root
        if(largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // recursively heapify the affected subtree
            heapify(array, n, largest);
        }
    }
}