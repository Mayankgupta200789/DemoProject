package general;

/**
 * @Author Mayank Gupta
 * @Date 1/5/18
 */
public class MathPower {

	public static void main(String[] args) {

		MathPower mathPower = new MathPower();

		double myPow = mathPower.myPow(2, 11);

		double myPowWithoutRecursion = mathPower.myPowWithoutRecursion(2, 11);

		System.out.println(myPow);
		System.out.println(myPowWithoutRecursion);

	}

	public double myPow(double x, int n) {

		if( n == 0 ) return 1;
		else if ( n < 0 ) {
			n = -n;
			x = 1/x;
		}

		return (n % 2 == 0 ) ? myPow(x * x, n >>>= 1) : x * myPow( x * x , n >>>= 1);

	}

	public double myPowWithoutRecursion(double x ,int n ) {

		if (  n < 0 ) {
			n = -n;
			x = (1/x);
		}

		double count = 0;

		while( n > 1 ) {


			if( n % 2 != 0 ) count = x;

			x *= x;

			n >>>= 1;

		}

		while( count > 1 ) {

			x *= count;

			count /= 2;
		}

		return x;


	}
}
