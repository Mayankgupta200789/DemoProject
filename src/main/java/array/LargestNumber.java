package array;

import java.util.*;

/**
 * @Author Mayank Gupta
 * @Date 1/19/18
 */
public class LargestNumber {

	public static void main(String[] args) {
		LargestNumber largestNumber = new LargestNumber();
		List<Integer> inputs = Arrays.asList(99, 990, 95);
		largestNumber.largestNumber(inputs);
		largestNumber.largestNumber(new int[]{999999998,999999997,999999999});
	}

	private String largestNumber(final List<Integer> A) {


		StringBuilder result = new StringBuilder();

		List<Integer> inputs = new ArrayList<>(A);

		inputs.sort((a, b) -> {

			int count1 = 1;
			int count2 = 1;
			int c = a;
			int d = b;


			while (a / 10 != 0) {
				a /= 10;
				count1++;
			}

			while (b / 10 != 0) {
				b /= 10;
				count2++;
			}
			// 1 4
			// 14
			// 41
			int result1 = c * (int) Math.pow(10, count2) + d;
			int result2 = d * (int) Math.pow(10, count1) + c;

			return Integer.compare(result2, result1);
		});

		boolean firstDigit = true;

		for (Integer input : inputs)
		{
			if( firstDigit && input != 0 ) {
				result.append(String.valueOf(input));
				firstDigit = false;
			} else if (!firstDigit) {
				result.append(String.valueOf(input));
			}
		}


		return result.toString().isEmpty() ? "0" : result.toString();
	}

	private String largestNumber(int[] B) {


		StringBuilder result = new StringBuilder();

		if(B == null || B.length == 0 ) {
			return result.toString();
		}

		Integer[] A = new Integer[B.length];

		for(int i = 0; i < A.length ; i++ ) {
			A[i] = B[i];
		}


		Arrays.sort(A, (a, b) -> {
			int count1 = 1;
			int count2 = 1;
			int c = a;
			int d = b;

			// 39   38  33
			while ( a / 10 != 0) {
				a /= 10;
				count1++;
			}

			while ( b / 10 != 0) {
				b /= 10;
				count2++;
			}
			// 1 4
			// 14
			// 41
			long result1 = c * (long) Math.pow(10, count2) + d;
			long result2 = d * (long) Math.pow(10, count1) + c;

			return Long.compare(result2, result1);
		});

		boolean firstDigit = true;

		for (Integer aA : A) {
			if (firstDigit && aA != 0) {
				result.append(aA);
				firstDigit = false;
			} else if (!firstDigit) {
				result.append(aA);
			}
		}


		return result.toString().isEmpty() ? "0" : result.toString();

	}
}
