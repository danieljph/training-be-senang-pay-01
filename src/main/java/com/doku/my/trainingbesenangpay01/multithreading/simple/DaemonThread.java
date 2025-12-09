package com.doku.my.trainingbesenangpay01.multithreading.simple;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class DaemonThread extends Thread
{
    @Override
    public void run()
    {
        for(int i = 1; i <= 10; i++)
        {
            System.out.println("[DaemonThread] Run " + i);

            try
            {
                Thread.sleep(1_000);
            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace(System.err);
            }
        }
    }
}
