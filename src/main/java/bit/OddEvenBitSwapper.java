package bit;

public class OddEvenBitSwapper {


    public static void main(String[] args) {

        new OddEvenBitSwapper().swap(12);
    }

    public int swap(int x) {
        return ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1);
    }
}
