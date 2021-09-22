package array;


//        Write a program that takes an array A and an index i into A, and rearranges the
//        elements such that all elements less than A[i] (the "pivot") appear first, followed by
//        elements equal to the pivot, followed by elements greater than the pivot.
public class Partition {

    public int[] partition(int[] inputs) {

        int low = 0;
        int high =  inputs.length - 1;

        int mid = (low + high ) /2;

        // 2,3,1,0,5,1,-1 - 7

        // 5  4 3 2 0 7 8 9 10
        // 10 4 3 2 0 7 8 9 5
        // 10 9 3 2 0 7 8 4 5
        // 10 9 8 2 0 7 3 4 5
        // 10 9 8 7 0 2 3 4 5


        // 5  4 3 2 10 7 8 9 10
        // 10 4 3 2 0 7 8 9 5
        // 10 9 3 2 0 7 8 4 5
        // 10 9 8 2 0 7 3 4 5
        // 10 9 8 7 0 2 3 4 5

        while(low < high ) {

            if(inputs[low] < inputs[mid]) {
                low++;
            }

            if(inputs[mid] < inputs[high]) {
                high--;
            }

            if(low <= high ) {
                swap(inputs,low,high);
                low++;
                high--;
            }
        }

        return inputs;
    }

    public void swap(int[] inputs, int first, int second ) {

        int temp = inputs[first];
        inputs[first] = inputs[second];
        inputs[second] = temp;

    }


}
