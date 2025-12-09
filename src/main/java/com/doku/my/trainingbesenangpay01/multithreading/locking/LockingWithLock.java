package com.doku.my.trainingbesenangpay01.multithreading.locking;

import com.doku.my.trainingbesenangpay01.util.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class LockingWithLock
{
    private final List<String> listOfData = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void addData(String data)
    {
        try
        {
            boolean isLockAcquired = lock.tryLock(1, TimeUnit.SECONDS);

            if(isLockAcquired)
            {
                try
                {
                    if(!listOfData.contains(data))
                    {
                        listOfData.add(data);
                        CommonUtils.sleep(2000);
                    }
                }
                finally
                {
                    lock.unlock();
                }
            }
            else
            {
                System.out.printf("Failed to acquire lock. Adding data '%s' will aborted.%n", data);
            }
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace(System.err);
        }
    }

    public void printData()
    {
        System.out.printf("Data (%s): %s%n", listOfData.size(), listOfData);
    }

    public static void main(String[] args) throws InterruptedException
    {
        LockingWithLock lockingWithLock = new LockingWithLock();

        Runnable runnable = () ->
        {
            for(int i=1; i<=10; i++)
            {
                lockingWithLock.addData("John-" + i);
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

        lockingWithLock.printData();
    }
}
