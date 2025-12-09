package com.doku.my.trainingbesenangpay01.multithreading.simple;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class MultithreadingTest
{
    public static void main(String[] args)
    {
        SimpleThreadExtendsThread thread1 = new SimpleThreadExtendsThread();

        SimpleThreadImplementRunnable simpleThreadImplementRunnable = new SimpleThreadImplementRunnable();
        Thread thread2 = new Thread(simpleThreadImplementRunnable);

        DaemonThread thread3 = new DaemonThread();
        thread3.setDaemon(true);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
