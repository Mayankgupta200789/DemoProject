package companies.versanetworks;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetProblem {


    public List<List<Integer>> getSubSet(List<Integer> inputs) {

       if(inputs == null ) return null;
       List<List<Integer>> result = new ArrayList<>();
       result.add(new ArrayList<>());

       for(int number : inputs ) {

            int n = result.size();
            for(int i = 0; i < n; i++  ){

                List<Integer> set = result.get(i);
                set.add(number);
                result.add(new ArrayList<>(set));
            }
        }

        return result;

    }

}
