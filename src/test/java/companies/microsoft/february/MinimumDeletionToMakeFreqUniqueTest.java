package companies.microsoft.february;

import junit.framework.TestCase;

public class MinimumDeletionToMakeFreqUniqueTest extends TestCase {

    public void testMinDeletions() {

        MinimumDeletionToMakeFreqUnique minimumDeletionToMakeFreqUnique = new MinimumDeletionToMakeFreqUnique();


        minimumDeletionToMakeFreqUnique.minDeletions("aabbbccdedd");
    }
}