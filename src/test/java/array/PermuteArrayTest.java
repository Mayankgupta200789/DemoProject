package array;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PermuteArrayTest {

    private PermuteArray permuteArray;

    @Test
    public void permute() {

        permuteArray = new PermuteArray();

        permuteArray.permute(new int[]{1, 2, 3, 4, 5});
    }


}