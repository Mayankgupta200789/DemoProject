package companies.microsoft.february;

public class FebOptimalQuestion {


    public static void main(String[] args) {
        System.out.println(new FebOptimalQuestion().optimize(new int[]{1,2,3,4,5,6,7,4,3,2,3}));
    }

    public int optimize(int[] A) {

        int N = A.length, result = 0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                // When the indexes are same, it will always return zero
                // Also, we need to keep looking forward as previous indexes are already checked
                if(A[i] == A[j] && result < Math.abs(i - j)) {
                    result = Math.max(result,Math.abs(i-j));
                }
            }
        }
        return result;

    }
}
