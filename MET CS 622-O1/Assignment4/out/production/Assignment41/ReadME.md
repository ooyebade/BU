##Concurrency

1. Genome sequence is a character string that include A,T,G,C.
2. Create a program that creates 100 random genome sequence each should be 10 character
long, e.g. ATGGCAACAG, CAACATCAGC, TTCTCTGTTT.
3. After creating this program now use concurrency to make this program faster. For example, we can use five threads to create 20 genome sequence each.
4. Report the differences between single thread and multithread run. Having no significant
differences is not a problem.

The purpose of this assignment is to first create a program that creates 100 random genome sequence each should be 10 character long. Then, after creating the program, use concurrency to make the program faster (use five threads to create 20 genome sequence each). And lastly comparing the differences between single thread and multithread run

This assignment is developed using OOPs concepts such as *Try/Catch Block*, *StringBuilder* and so on.*

The GenomeSeqExecutor.java has the following:

* A main method that is the starting point of execution for the program.
* The *randomGenomeSequences* method that is being used to generate the genome sequences randomly
* The *singleThread* method that is being executed to manage single thread method and add 100 random entries to the list.
* The *multiThread* method that is being executed to manage multi thread method and add 20 random entries to the list.
