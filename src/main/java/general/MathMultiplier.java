package general;

/**
 * @Author Mayank Gupta
 * @Date 1/5/18
 */
public class MathMultiplier {

	public static void main(String[] args) {

		MathMultiplier mathMultiplier = new MathMultiplier();

		double myMult = mathMultiplier.myMult(8.4732, 5);

		System.out.println(myMult);

	}

	public double myMult(double x, int n) {

		if( n == 0 ) return 0;


		return (n % 2 == 0 ) ? myMult(x + x, n >>>= 1) : x + myMult( x + x , n >>>= 1);

	}
}
