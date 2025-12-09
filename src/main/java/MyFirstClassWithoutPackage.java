import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class MyFirstClassWithoutPackage
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        long l1 = System.currentTimeMillis();

        double result = 0;

        for(int i=0; i<Integer.MAX_VALUE; i++)
        {
            result = result + i;
        }

        long l2 = System.currentTimeMillis();
        long duration = l2 - l1;

        System.out.println("Result  : " + result);
        System.out.println("Duration: " + Duration.of(duration, ChronoUnit.MILLIS));

        new MySecondClassWithoutPackage().sayHello();
    }
}
