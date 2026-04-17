package sit707_week5;

import org.junit.Assert;
import org.junit.Test;

public class WeatherControllerTest {

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

//	@Test
//	public void testTemperatureMin() {
//		System.out.println("+++ testTemperatureMin +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		// Retrieve all the hours temperatures recorded as for today
//		int nHours = wController.getTotalHours();
//		double minTemperature = 1000;
//		for (int i=0; i<nHours; i++) {
//			// Hour range: 1 to nHours
//			double temperatureVal = wController.getTemperatureForHour(i+1); 
//			if (minTemperature > temperatureVal) {
//				minTemperature = temperatureVal;
//			}
//		}
//		
//		// Should be equal to the min value that is cached in the controller.
//		Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
//		
//		// Shutdown controller
//		wController.close();		
//	}
//	
//	@Test
//	public void testTemperatureMax() {
//		System.out.println("+++ testTemperatureMax +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		// Retrieve all the hours temperatures recorded as for today
//		int nHours = wController.getTotalHours();
//		double maxTemperature = -1;
//		for (int i=0; i<nHours; i++) {
//			// Hour range: 1 to nHours
//			double temperatureVal = wController.getTemperatureForHour(i+1); 
//			if (maxTemperature < temperatureVal) {
//				maxTemperature = temperatureVal;
//			}
//		}
//		
//		// Should be equal to the min value that is cached in the controller.
//		Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
//		
//		// Shutdown controller
//		wController.close();
//	}
//
//	@Test
//	public void testTemperatureAverage() {
//		System.out.println("+++ testTemperatureAverage +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		// Retrieve all the hours temperatures recorded as for today
//		int nHours = wController.getTotalHours();
//		double sumTemp = 0;
//		for (int i=0; i<nHours; i++) {
//			// Hour range: 1 to nHours
//			double temperatureVal = wController.getTemperatureForHour(i+1); 
//			sumTemp += temperatureVal;
//		}
//		double averageTemp = sumTemp / nHours;
//		
//		// Should be equal to the min value that is cached in the controller.
//		Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
//		
//		// Shutdown controller
//		wController.close();
//	}
	
	@Test
	public void testTemperaturePersist() {
	    System.out.println("+++ testTemperaturePersist +++");

	    // Initialise controller
	    WeatherController wController = WeatherController.getInstance();

	    String persistTime = wController.persistTemperature(10, 19.5);
	    String now = new java.text.SimpleDateFormat("H:m:s").format(new java.util.Date());

	    System.out.println("Persist time: " + persistTime + ", now: " + now);

	    try {
	        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("H:m:s");

	        java.util.Date persistDate = sdf.parse(persistTime);
	        java.util.Date nowDate = sdf.parse(now);

	        long timeDifference = Math.abs(nowDate.getTime() - persistDate.getTime());

	        Assert.assertTrue("Time difference is too large", timeDifference <= 2000);

	    } catch (java.text.ParseException e) {
	        Assert.fail("Time parsing failed");
	    }

	    wController.close();
	}
}