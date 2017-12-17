package sort;

/**
 * @Author Mayank Gupta
 * @Date 12/11/17
 *
 * Time Complexity
 *      Best Case :     O(n log n )
 *      Average Case :  O(n log n )
 *      Worst Case   :  O( n ^ 2 )
 *
 * Space Complexity
 *
 *      Best Case :     O( log n )
 *      Worst Case :    O( n )
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] inputs = new int[] {4,3,2,1,34,1,2,4,3,5,4,6,5};

        QuickSort quickSort = new QuickSort();

        quickSort.quickSort(inputs,0,inputs.length - 1);

        for (int output : inputs ){
            System.out.print(output + "\t");
        }


    }




    public void quickSort(int[] inputs,int low, int high ) {

        int mid = partition(inputs,low, high );

        if( low < mid - 1 ){
            quickSort(inputs,low,mid - 1 );
        }

        if(mid < high ) {
            quickSort(inputs,mid, high);
        }
    }

    private int partition(int[] inputs, int low, int high) {

        int mid = (low + high )/2;

        while( low < high ) {

            while( inputs[low] < inputs[mid] && low < mid ) {
                low++;
            }

            while( inputs[high] > inputs[mid] && high > mid ) {
                high--;
            }

            if( low <= high ) {
                swap(inputs, low, high);
                low++;
                high--;
            }
        }

        return low;

    }

    private void swap(int[] inputs, int index1,int index2 ) {

        int temp = inputs[index1];

        inputs[index1] = inputs[index2];

        inputs[index2] = temp;

    }
}
