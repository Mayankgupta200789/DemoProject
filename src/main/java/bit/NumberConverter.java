package bit;

public class NumberConverter {

    public static void main(String[] args) {

        new NumberConverter().bitSwapRequired(4,10);
    }


    public int bitSwapRequired(int a, int b) {

        int count = 0;

        for(int c = a ^ b; c != 0; c = c & (c - 1)) {
            count ++;
        }


        return count;


    }
}
