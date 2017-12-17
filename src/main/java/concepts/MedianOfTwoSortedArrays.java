package concepts;

import java.util.LinkedList;

/**
 * @Author Mayank Gupta
 * @Date 12/30/16
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0;
        int j = 0;
        int k = 0;

        int len1 = nums1.length;
        int len2 = nums2.length;
        int len3 = len1 + len2;

        LinkedList<Integer> total = new LinkedList<>();




        while( i < nums1.length && j < nums2.length ) {

            if(nums1[i] > nums2[j]) {
                total.add(nums2[j++]);
            }else {
                total.add(nums1[i++]);
            }
        }

        while( i < nums1.length ) {
            total.add(nums1[i++]);
        }


        while( j < nums2.length ) {
            total.add(nums2[j++]);
        }

        int outputSize = total.size();

        if( outputSize % 2 != 0 ) {
            return total.get(outputSize/2);
        }else {
            double a = total.get(outputSize/2) + total.get(outputSize/2 - 1);
            double result = a/2;
            return result;

        }


    }
}
