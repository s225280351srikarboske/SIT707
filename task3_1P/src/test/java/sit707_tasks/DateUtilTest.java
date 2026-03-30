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
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
		System.out.println("january31ShouldIncrementToFebruary1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(1, date.getDay());
	}

	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
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
	}

	/*
	 * Complete below test cases.
	 */

	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
		date.increment();

		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
		date.decrement();

		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testFebruary28IncrementLeapYear() {
		DateUtil date = new DateUtil(28, 2, 2024);
		date.increment();
		Assert.assertEquals(29, date.getDay());
	}

	@Test
	public void testFebruary29IncrementToMarch1() {
		DateUtil date = new DateUtil(29, 2, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMarch31IncrementToApril1() {
		DateUtil date = new DateUtil(31, 3, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testApril30IncrementToMay1() {
		DateUtil date = new DateUtil(30, 4, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMay31IncrementToJune1() {
		DateUtil date = new DateUtil(31, 5, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testJune30IncrementToJuly1() {
		DateUtil date = new DateUtil(30, 6, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testJuly31IncrementToAugust1() {
		DateUtil date = new DateUtil(31, 7, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testAugust31IncrementToSeptember1() {
		DateUtil date = new DateUtil(31, 8, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testSeptember30IncrementToOctober1() {
		DateUtil date = new DateUtil(30, 9, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testOctober31IncrementToNovember1() {
		DateUtil date = new DateUtil(31, 10, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void testNovember30IncrementToDecember1() {
		DateUtil date = new DateUtil(30, 11, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testDecember31IncrementToJanuaryNextYear() {
		DateUtil date = new DateUtil(31, 12, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2025, date.getYear());
	}
	
}
