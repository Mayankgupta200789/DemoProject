package companies.microsoft.february;

import org.apache.commons.collections4.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

public class FebOptimalQuestion {


    public static void main(String[] args) {
        System.out.println(new FebOptimalQuestion().optimize(new int[]{1,2,3,4,5,6,7,4,3,2,3,9,8,7,8,9,8,91,11,12,12,31,14}));
        System.out.println(new FebOptimalQuestion().optimize2(new int[]{1,2,3,4,5,6,7,4,3,2,3,9,8,7,8,9,8,91,11,12,12,31,14}));
    }

    public int optimize(int[] A) {

        int N = A.length, result = Integer.MIN_VALUE;
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<N;i++){

            if(!hashMap.containsKey(A[i])) {
                hashMap.put(A[i],i);
            } else {
                result = Math.max(result,Math.abs(i - hashMap.get(A[i])));
            }
        }
        return result;

    }

    public int optimize2(int[] A) {

        int N = A.length, result = 0;
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){
                // When the indexes are same, it will always return zero
                // Also, we need to keep looking forward as previous indexes are already checked
                if(A[i] == A[j] ) {
                    result = Math.max(result,Math.abs(i-j));
                }
            }
        }
        return result;
    }
}
