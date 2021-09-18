package bit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConceptTest {

    private Concept concept;

    @Before
    public void setUp() throws Exception {

        concept = new Concept();
    }

    @Test
    public void checkBitwise() {

        concept.checkBitwise();
    }
}