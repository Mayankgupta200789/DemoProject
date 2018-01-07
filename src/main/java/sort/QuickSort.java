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

//        quickSort.quickSort(inputs,0,inputs.length - 1);
        quickSort.quickSort2(inputs,0,inputs.length - 1);

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

    public  void quickSort2(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort2(arr, low, j);

        if (high > i)
            quickSort2(arr, i, high);
    }
}
