package companies.microsoft.february;

public class FebProductQuestion {

    public int arraySign(int[] nums) {

        int numberOfNegative = 0;

        for(int i = 0; i < nums.length; i++ ) {

            if( nums[i] < 0 ) {
                numberOfNegative++;
            }

            if( nums[i] == 0 ) {
                return 0;
            }
        }

        if(numberOfNegative > 0 ) {
            if(numberOfNegative % 2 == 0 ) return 1;
            else return -1;
        }

        return 1;
    }
}
