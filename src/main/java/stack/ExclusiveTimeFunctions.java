package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeFunctions {
    private Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        ExclusiveTimeFunctions exclusiveTimeFunctions = new ExclusiveTimeFunctions();

        List<String> list = Arrays.asList("0:start:0",
                "1:start:2",
                "1:end:5",
                "0:end:6");
        exclusiveTimeFunctions.exclusiveTime(2,list);
    }

    public int[] exclusiveTime(int n, List<String> logs) {

        int[] result = new int[n];

        int prevTime = 0;

        for(String log : logs ) {

            String[] parts = log.split(":");

            if(!stack.isEmpty()) result[stack.peek()] += Integer.parseInt(parts[2]) - prevTime;

            prevTime = Integer.parseInt(parts[2]);

            if(parts[1].equals("start")) stack.push(Integer.parseInt(parts[0]));
            else {
                result[stack.pop()]++;
                prevTime++;
            }



        }

        return result;

    }
}
