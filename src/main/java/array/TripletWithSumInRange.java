package array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author Mayank Gupta
 * @Date 1/17/18
 */
public class TripletWithSumInRange {

	public static void main(String[] args) {

		ArrayList<String> inputs = new ArrayList<>();

		inputs.add("0.503094");
		inputs.add("0.648924");
		inputs.add("0.999298");

		TripletWithSumInRange tripletWithSumInRange = new TripletWithSumInRange();


		tripletWithSumInRange.solve(inputs);


	}

	public int solve(ArrayList<String> A) {

		ArrayList<Double> inputs = new ArrayList<>();

		for (int i = 0; i < A.size(); i++) {

			inputs.add(Double.parseDouble(A.get(i)));
		}

		Collections.sort(inputs);

		int len = inputs.size();
		int k;
		int j;

		for (int i = 0; i < len; i++) {

			k = len - 1;
			j = 0;
			while (j < len && k >= 0) {

				double sum = inputs.get(i) + inputs.get(j) + inputs.get(k);

				if (i != j && j != k && i != k && sum > 1 && sum < 2) {
					return 1;
				} else if (i != j && j != k && sum <= 1) {
					j++;
				} else if (i != j && j != k && sum >= 2) {
					k--;
				} else if (j == k) {
					j++;
					k--;
				} else if (i == j || i == k) {
					break;
				}
			}
		}


		return 0;


	}
}
