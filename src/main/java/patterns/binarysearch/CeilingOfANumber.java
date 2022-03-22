package patterns.binarysearch;


//Time Complexity - O(log N )
//Space complexity - O(1)
public class CeilingOfANumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {

        if (key > arr[arr.length - 1]) return -1;

        // [4, 6, 10], key = 17
        int start = 0, end = arr.length - 1;
        int mid = 0;

        while (start <= end) {

            mid = (start + end) / 2;

            if (key == arr[mid]) return mid;

            if (key > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array, so the next big number will be arr[start]
        return start;
    }

    public static void main(String[] args) {
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[]{4, 6, 10}, 6));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[]{4, 6, 10}, 17));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[]{4, 6, 10}, -1));
    }
}
