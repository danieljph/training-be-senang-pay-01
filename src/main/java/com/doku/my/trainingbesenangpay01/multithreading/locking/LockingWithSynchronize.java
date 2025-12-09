package com.doku.my.trainingbesenangpay01.multithreading.locking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class LockingWithSynchronize
{
    private final List<String> listOfData = new ArrayList<>();

    public synchronized void addData(String data)
    {
        if(!listOfData.contains(data))
        {
            listOfData.add(data);
        }
    }

    public void printData()
    {
        System.out.printf("Data (%s): %s%n", listOfData.size(), listOfData);
    }

    public static void main(String[] args) throws InterruptedException
    {
        LockingWithSynchronize lockingWithSynchronize = new LockingWithSynchronize();

        Runnable runnable = () ->
        {
            for(int i=1; i<=10; i++)
            {
                lockingWithSynchronize.addData("John-" + i);
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        lockingWithSynchronize.printData();
    }
}
