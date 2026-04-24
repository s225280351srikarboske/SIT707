package web.service;

public class MathQuestionService {

	public static double q1Addition(String number1, String number2) {
		if (isInvalid(number1) || isInvalid(number2)) {
			return Double.NaN;
		}
		try {
			return Double.valueOf(number1) + Double.valueOf(number2);
		} catch (NumberFormatException e) {
			return Double.NaN;
		}
	}

	public static double q2Subtraction(String number1, String number2) {
		if (isInvalid(number1) || isInvalid(number2)) {
			return Double.NaN;
		}
		try {
			return Double.valueOf(number1) - Double.valueOf(number2);
		} catch (NumberFormatException e) {
			return Double.NaN;
		}
	}

	public static double q3Multiplication(String number1, String number2) {
		if (isInvalid(number1) || isInvalid(number2)) {
			return Double.NaN;
		}
		try {
			return Double.valueOf(number1) * Double.valueOf(number2);
		} catch (NumberFormatException e) {
			return Double.NaN;
		}
	}

	private static boolean isInvalid(String value) {
		return value == null || value.trim().isEmpty();
	}
}