package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import static org.junit.Assert.*;

public class JumpGameTest {

    private JumpGame jumpGame;

    @Before
    public void setUp() throws Exception {
        jumpGame = new JumpGame();
    }

    @Test
    public void canJump5() throws IOException {
        InputStream resourceAsStream = getClass().getResourceAsStream("../LargeArray.properties");

        Properties properties = new Properties();
        properties.load(resourceAsStream);

        String input = properties.get("LargeArray.regexp").toString();
        int[] inputs = Arrays.stream(input.substring(1, input.length()-1).split(","))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();
        Assert.assertFalse(jumpGame.canJump(inputs));
    }

}