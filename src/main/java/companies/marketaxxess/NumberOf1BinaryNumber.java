package companies.marketaxxess;

public class NumberOf1BinaryNumber {

    public static void main(String[] args) {

        System.out.println(new NumberOf1BinaryNumber().count(124));
    }

    public int count(int n ) {

        int count = 0;

        while(n != 0 ) {
            n = n & (n - 1);
            count += 1;

        }
        return count;
    }
}
