package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] hourlyTemperatures;
    private static double minTemperature;
    private static double maxTemperature;
    private static double averageTemperature;

    @BeforeClass
    public static void setUpBeforeClass() {
        
        wController = WeatherController.getInstance();

        int totalHours = wController.getTotalHours();
        hourlyTemperatures = new double[totalHours];

        double sum = 0;
        minTemperature = Double.MAX_VALUE;
        maxTemperature = Double.MIN_VALUE;

        for (int i = 0; i < totalHours; i++) {
            hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);

            if (hourlyTemperatures[i] < minTemperature) {
                minTemperature = hourlyTemperatures[i];
            }

            if (hourlyTemperatures[i] > maxTemperature) {
                maxTemperature = hourlyTemperatures[i];
            }

            sum += hourlyTemperatures[i];
        }

        averageTemperature = sum / totalHours;
    }

    @AfterClass
    public static void tearDownAfterClass() {
        if (wController != null) {
            wController.close();
        }
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "225280351";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Srikar Boske";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        
        double cachedMin = wController.getTemperatureMinFromCache();

        
        Assert.assertEquals(minTemperature, cachedMin, 0.0001);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        double cachedMax = wController.getTemperatureMaxFromCache();

        Assert.assertEquals(maxTemperature, cachedMax, 0.0001);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        double cachedAverage = wController.getTemperatureAverageFromCache();

        Assert.assertEquals(averageTemperature, cachedAverage, 0.0001);
    }

    @Test
    public void testTemperaturePersist() {
        /*
         * Remove below comments ONLY for 5.3C task.
         */
//      System.out.println("+++ testTemperaturePersist +++");
//
//      // Initialise controller
//      WeatherController wController = WeatherController.getInstance();
//
//      String persistTime = wController.persistTemperature(10, 19.5);
//      String now = new SimpleDateFormat("H:m:s").format(new Date());
//      System.out.println("Persist time: " + persistTime + ", now: " + now);
//
//      Assert.assertTrue(persistTime.equals(now));
//
//      wController.close();
    }
}