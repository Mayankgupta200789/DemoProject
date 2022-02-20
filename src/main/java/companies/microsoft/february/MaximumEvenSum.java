package companies.microsoft.february;

public class MaximumEvenSum {

    public static void main(String[] args) {



    }

    public int maxEvenSum(int arr[], int n) {
        int result = 0;

        for(int i = 0 ; i < n; i++ ) {

            result += arr[i];
        }

        int ans = Integer.MIN_VALUE;
        if(result % 2 == 0 ) {
            return result;
        } else {

            for(int i = 0 ; i < n; i++ ) {

                if(arr[i] % 2 != 0 ) {

                    if(arr[i] > 0 ) {

                        ans = Math.max(ans, result - arr[i]);

                    } else {
                        ans = Math.max(ans, result + arr[i]);
                    }

                }

            }
        }
        return ans;
    }
}
