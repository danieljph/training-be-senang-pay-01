package com.doku.my.trainingbesenangpay01.multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class ThreadPoolExample implements Runnable
{
    private final String producerName;

    public ThreadPoolExample(String producerName)
    {
        this.producerName = producerName;
    }

    @Override
    public void run()
    {
        for(int i = 1; i <= 10; i++)
        {
            System.out.printf("[%s] Run %s%n", producerName, i);

            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace(System.err);
            }
        }
    }

    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i = 1; i <= 5; i++)
        {
            Runnable worker = new ThreadPoolExample("Producer-" + i);
            executor.execute(worker);
        }

        // Initiate a graceful shutdown of the thread pool
        executor.shutdown();

        // Wait for all tasks to complete or for a timeout
        try
        {
            if(!executor.awaitTermination(60, TimeUnit.SECONDS))
            {
                System.err.println("Thread pool did not terminate in the allotted time.");
            }
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.err.println("Thread pool termination interrupted: " + ex.getMessage());
        }

        System.out.println("All tasks submitted and thread pool shutdown initiated.");
    }
}
