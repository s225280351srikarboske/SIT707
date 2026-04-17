package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class LoopFunctionsTest {

	@Test
	public void testSumUpToZero() {
		Assert.assertEquals(0, LoopFunctions.sumUpTo(0));
	}

	@Test
	public void testSumUpToOne() {
		Assert.assertEquals(1, LoopFunctions.sumUpTo(1));
	}

	@Test
	public void testSumUpToFive() {
		Assert.assertEquals(15, LoopFunctions.sumUpTo(5));
	}

	@Test
	public void testCountEvenNumbersZero() {
		Assert.assertEquals(0, LoopFunctions.countEvenNumbers(0));
	}

	@Test
	public void testCountEvenNumbersOne() {
		Assert.assertEquals(0, LoopFunctions.countEvenNumbers(1));
	}

	@Test
	public void testCountEvenNumbersFive() {
		Assert.assertEquals(2, LoopFunctions.countEvenNumbers(5));
	}

	@Test
	public void testCountEvenNumbersSix() {
		Assert.assertEquals(3, LoopFunctions.countEvenNumbers(6));
	}
}