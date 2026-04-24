package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

	@Test
	public void testQ1AdditionValidNumbers() {
		Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0);
	}

	@Test
	public void testQ1AdditionEmptyNumber1() {
		Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("", "2")));
	}

	@Test
	public void testQ1AdditionEmptyNumber2() {
		Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("1", "")));
	}

	@Test
	public void testQ1AdditionInvalidInput() {
		Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("abc", "2")));
	}

	@Test
	public void testQ2SubtractionValidNumbers() {
		Assert.assertEquals(4.0, MathQuestionService.q2Subtraction("7", "3"), 0);
	}

	@Test
	public void testQ2SubtractionEmptyInput() {
		Assert.assertTrue(Double.isNaN(MathQuestionService.q2Subtraction("", "3")));
	}

	@Test
	public void testQ2SubtractionInvalidInput() {
		Assert.assertTrue(Double.isNaN(MathQuestionService.q2Subtraction("abc", "3")));
	}

	@Test
	public void testQ3MultiplicationValidNumbers() {
		Assert.assertEquals(12.0, MathQuestionService.q3Multiplication("4", "3"), 0);
	}

	@Test
	public void testQ3MultiplicationEmptyInput() {
		Assert.assertTrue(Double.isNaN(MathQuestionService.q3Multiplication("", "3")));
	}

	@Test
	public void testQ3MultiplicationInvalidInput() {
		Assert.assertTrue(Double.isNaN(MathQuestionService.q3Multiplication("abc", "3")));
	}
}