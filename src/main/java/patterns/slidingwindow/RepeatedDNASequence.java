package patterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {

    public List<String> findRepeatedDnaSequences(String s) {

        if(s == null || s.length() < 10 ) {return new ArrayList<>();}

        int windowStart = 0;

        Set<String> hashSet = new HashSet<>();
        Set<String> output = new HashSet<>();

        for(int windowEnd = 9; windowEnd < s.length(); windowEnd++ ) {

            String input = s.substring(windowStart,windowEnd+1);
            if(hashSet.contains(input)){
                output.add(input);
            } else {
                hashSet.add(input);
            }
            windowStart++;

        }

        return new ArrayList<>(output);

    }
}
