package array;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NextNumberTest {

    private NextNumber nextNumber;

    @Before
    public void setUp() throws Exception {

        nextNumber = new NextNumber();
    }

    @Test
    public void plusOne() {

        List<Integer> input = new ArrayList<>();
        input.add(9);
        input.add(9);
        nextNumber.plusOne(input);
    }
}