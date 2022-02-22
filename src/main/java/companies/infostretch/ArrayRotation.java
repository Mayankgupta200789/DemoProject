package companies.infostretch;
/* Instructions to candidate.

1) A left rotation operation on an array of size N shifts each of the array's elements 1 unit to the left.

For example, if 2 left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2].

Given an array of N integers and a number, D, perform D left rotations on the array

2) Consider adding further tests to main().
3) Implement the function arrayLeftRotation() correctly, and fix the test in main(). */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayRotation {

    public static void ps(int[] in) {
        System.out.println(Arrays.toString(in));
    }

    public static int[] arrayLeftRotation(int[] a, int d) {
        //int[] a = {1,2,3,4,5,6};
        // d = 4
        if( d == a.length || d == 0) return a;

        if( d > a.length ) d = d % a.length;

        int count = 0;

        int i = d;
        // i = 4

        int[] result = new int[a.length];
        int j = 0;
        // i = 6
        // j = 1;


        while( count < a.length) {

            result[j++] = a[i++];


            if(i == a.length ) i = 0;

            count++;
        }
        System.out.println(Arrays.toString(a));


        return result;
    }

    // you can change anything
    public static void main(String[] args) {
        int d = 4;

        int[] a = {1,2,3,4,5,6};

        int[] output = {5,6,1,2,3,4};  // expected output

        int[] res = arrayLeftRotation(a,d);

        int count = 0;
        for(int i = 0 ; i < output.length; i++ ){


            if(output[i] == res[i]) {
                count++;
            }

        }

        for(int i = 0; i < res.length;i++ ) {

            System.out.println("res "  + res[i]);
        }
        // TO-DO: fix tests
        if ( count == a.length )
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");
    }
}
