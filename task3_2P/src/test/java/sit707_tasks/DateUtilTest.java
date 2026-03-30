package sit707_tasks;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;


public class DateUtilTest {
	
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
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertTrue(date.getDay() >= 1 && date.getDay() <= 31);
	}
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("january1ShouldIncrementToJanuary2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("january1ShouldDecrementToDecember31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
	}
	

	@Test
	public void testValidDayBetween1And28() {
		DateUtil date = new DateUtil(15, 1, 2023);
		date.increment();
		Assert.assertEquals(16, date.getDay());
		Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testValidDay29InLeapYearFebruary() {
		DateUtil date = new DateUtil(29, 2, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testValidDay30InApril() {
		DateUtil date = new DateUtil(30, 4, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(5, date.getMonth());
	}
	
	@Test
	public void testValidDay31InMarch() {
		DateUtil date = new DateUtil(31, 3, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(4, date.getMonth());
	}
	
	@Test
	public void testFebruary28NonLeapYearShouldGoToMarch1() {
		DateUtil date = new DateUtil(28, 2, 2023);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
	}
	
	@Test
	public void testFebruary28LeapYearShouldGoToFebruary29() {
		DateUtil date = new DateUtil(28, 2, 2024);
		date.increment();
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
	}
	
	@Test
	public void testDecember31ShouldIncrementToJanuary1NextYear() {
		DateUtil date = new DateUtil(31, 12, 2023);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testInvalidDayTooLow() {
		Assert.assertThrows(RuntimeException.class, () -> {
			new DateUtil(0, 1, 2024);
		});
	}
	
	@Test
	public void testInvalidDayTooHigh() {
		Assert.assertThrows(RuntimeException.class, () -> {
			new DateUtil(32, 1, 2024);
		});
	}
	
	@Test
	public void testInvalidMonthTooLow() {
		Assert.assertThrows(RuntimeException.class, () -> {
			new DateUtil(10, 0, 2024);
		});
	}
	
	@Test
	public void testInvalidMonthTooHigh() {
		Assert.assertThrows(RuntimeException.class, () -> {
			new DateUtil(10, 13, 2024);
		});
	}
	
	@Test
	public void testInvalidYearTooLow() {
		Assert.assertThrows(RuntimeException.class, () -> {
			new DateUtil(10, 1, 1699);
		});
	}
	
	@Test
	public void testInvalidYearTooHigh() {
		Assert.assertThrows(RuntimeException.class, () -> {
			new DateUtil(10, 1, 2025);
		});
	}
	
	@Test
	public void testInvalid31InApril() {
		Assert.assertThrows(RuntimeException.class, () -> {
			new DateUtil(31, 4, 2024);
		});
	}
	
	@Test
	public void testInvalid29FebruaryNonLeapYear() {
		Assert.assertThrows(RuntimeException.class, () -> {
			new DateUtil(29, 2, 2023);
		});
	}
}