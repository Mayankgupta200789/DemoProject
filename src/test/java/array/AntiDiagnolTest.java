package array;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author Mayank Gupta
 * @Date 8/26/17
 */
public class AntiDiagnolTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void diagonal() throws Exception {

        ArrayList<ArrayList<Integer>> input = new ArrayList<>();

        ArrayList<Integer> input1 = new ArrayList<>();
        ArrayList<Integer> input2 = new ArrayList<>();
        ArrayList<Integer> input3 = new ArrayList<>();

        input1.add(1);
        input1.add(2);
        input1.add(3);
        input2.add(4);
        input2.add(5);
        input2.add(6);
        input3.add(7);
        input3.add(8);
        input3.add(9);
        input.add(input1);
        input.add(input2);
        input.add(input3);


        AntiDiagnol antiDiagnol = new AntiDiagnol();
        antiDiagnol.diagonal(input);
    }

}