package array;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Mayank Gupta
 * @Date 1/10/18
 */
public class DuplicateElementInArray {


	public static void main(String[] args) {


		List<Integer> inputs = Arrays.asList(3, 4, 1, 4, 1);

		DuplicateElementInArray duplicateElementInArray = new DuplicateElementInArray();

		duplicateElementInArray.repeatedNumber(inputs);
	}

	public int repeatedNumber(final List<Integer> a) {

		int x = 1;

		int n = a.size() - 1;

		for(int i = 2 ; i <= n; i++ ) {

			x ^= i;
		}


		for(int  e : a ) {
			x ^= e;
		}

		if( x == 0 )    return -1;

		return x;

	}
}
