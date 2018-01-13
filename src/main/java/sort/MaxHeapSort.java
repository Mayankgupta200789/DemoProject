package sort;

import java.util.Arrays;

/**
 * /**
 * @Author Mayank Gupta
 * @Date 12/11/17
 *
 * Time Complexity
 *      Best Case :     O(n log n )
 *      Worst Case :    O(n log n )
 *
 * Space Complexity
 *
 *      Worst Case :    O( 1 )
 *
 * HeapSort     vs      QuickSort
 *
 * Heapsort is O(N log N) guaranted, what is much better than worst case in Quicksort.
 * Heapsort don't need more memory for another array to putting ordered data as is needed by Mergesort.
 * So why do comercial applications stick with Quicksort? What Quicksort has that is so special over others implementations?

I've tested the algorithms myself and I've seen that Quicksort has something special indeed. It runs fast, much faster than Heap and Merge algorithms.

The secret of Quicksort is: It almost doesn't do unnecessary element swaps. Swap is time consuming.

With Heapsort, even if all of your data is already ordered, you are going to swap 100% of elements to order the array.

With Mergesort, it's even worse. You are going to write 100% of elements in another array and write it back in the original one, even if data is already ordered.

With Quicksort you don't swap what is already ordered. If your data is completely ordered, you swap almost nothing! Although there is a lot of fussing about worst case, a little improvement on the choice of pivot, any other than getting the first or last element of array, can avoid it. If you get a pivot from the intermediate element between first, last and middle element, it is suficient to avoid worst case.

What is superior in Quicksort is not the worst case, but the best case! In best case you do the same number of comparisons, ok, but you swap almost nothing. In average case you swap part of the elements, but not all elements, as in Heapsort and Mergesort. That is what gives Quicksort the best time. Less swap, more speed.

The implementation below in C# on my computer, running on release mode, beats Array.Sort by 3 seconds with middle pivot and by 2 seconds with improved pivot (yes, there is an overhead to get a good pivot).
 * @Author Mayank Gupta
 * @Date 12/12/17
 */
public class MaxHeapSort {


    public static void main(String[] args) {

        int[] inputs = new int[]  { 1,2,3,4,5,0};

        MaxHeapSort maxHeapSort = new MaxHeapSort();

        maxHeapSort.heapsort(inputs);

        Arrays.stream(inputs).forEach(input -> {
            System.out.print(input +"\t");
        });
    }


    public void heapsort(int[] inputs) {

        int n = inputs.length;

        for (int i = (n/2 - 1); i >= 0; i--)
            heapify(inputs, n, i);

        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            swap(inputs,0,i);

            // call max heapify on the reduced heap
            heapify(inputs, i, 0);
        }

    }



    private void heapify(int[] input, int n, int i) {

        while( i <= n ) {

            int largest = i;

            int low = 2 * i + 1;

            int high = 2 * i + 2;


            if (low < n && input[low] > input[largest]) {
                largest = low;
            }

            if (high < n && input[high] > input[largest]) {
                largest = high;
            }

            if (largest != i) {

                swap(input, i, largest);
                i = largest;
            } else {
                break;
            }
        }

    }

    private void swap (int[] input, int index1,int index2 ) {

        int temp = input[index1];

        input[index1] = input[index2];

        input[index2] = temp;

    }
}
