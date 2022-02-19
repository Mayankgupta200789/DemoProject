package companies.microsoft.february;

public class UniqueSumToZero {

    public int[] sumZero(int n) {

        if(n == 1 ){
            return new int[]{0};
        }


        int[] result = new int[n];

        int val  = 1;
        int val2 = -1;


        if(n % 2 == 0 ) {

            int k = n / 2;

            int l = k;
            l--;


            while(k < n && l >= 0  ){

                result[k] = val;
                result[l] = val2;
                k++;
                l--;
                val++;
                val2--;
            }


        } else {

            int i = n / 2;

            int j = i;
            result[i--] = 0;
            j++;


            while( i >= 0 && j < n ) {

                result[i] = val2;
                result[j] = val;
                i--;
                j++;
                val2--;
                val++;
            }

        }


        return result;
    }
}
