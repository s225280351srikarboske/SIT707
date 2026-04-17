package sit707_week6;

public class LoopFunctions {

	// Part B(a): conditional loop with simple instructions
	public static int sumUpTo(int n) {
		int sum = 0;
		int i = 1;

		while (i <= n) {
			sum = sum + i;
			i++;
		}

		return sum;
	}

	// Part B(b): conditional loop with conditional statement
	public static int countEvenNumbers(int n) {
		int count = 0;

		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				count++;
			}
		}

		return count;
	}
}