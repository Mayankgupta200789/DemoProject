package recursion;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Mayank Gupta
 * @Date 9/27/17
 */
public class SubsetString {

    public static void main(String[] args ) {

        SubsetString subsetString = new SubsetString();

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        List<String> inputList = new LinkedList<>();
        inputList.add("abcd");
        inputList.add("efh");
        inputList.add("hij");
        inputList.add("klmn");

        subsetString.countSubset(inputList,0,new LinkedList<String>());
    }


    public int countSubset(List<String> inputList, int count, List<String> chosen ) {

        if( inputList.isEmpty() ) {
            System.out.println(chosen);
            return ++count;
        } else {

            String takeFirstInput = inputList.get(0);
            chosen.add(takeFirstInput);
            inputList.remove(takeFirstInput);
            count = countSubset(inputList,count,chosen);
            chosen.remove(chosen.size() - 1);
            count = countSubset(inputList,count,chosen);
            inputList.add(0,takeFirstInput);
        }

        return count;
    }
}
