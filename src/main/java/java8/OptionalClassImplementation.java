package java8;

import java.util.*;

public class OptionalClassImplementation {

    public static void main(String[] args) throws Exception {


        List<String> inputs = Arrays.asList("Hello", "World");

        Optional<String> option = inputs.stream().filter(name -> name.startsWith("jim")).findAny();

        String output1 = option.orElse("Name not fonud");
        option.orElseThrow( () ->  new Exception(" Name not found"));
        option.map(Collections::singletonList)
                .orElse(Collections.emptyList());


    }
}
