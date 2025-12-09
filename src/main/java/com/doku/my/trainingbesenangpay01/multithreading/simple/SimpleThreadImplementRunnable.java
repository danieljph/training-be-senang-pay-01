package com.doku.my.trainingbesenangpay01.multithreading.simple;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class SimpleThreadImplementRunnable implements Runnable
{
    @Override
    public void run()
    {
        for(int i = 1; i <= 10; i++)
        {
            System.out.println("[SimpleThreadImplementRunnable] Run " + i);

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
}
