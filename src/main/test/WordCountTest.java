package main.test;

import main.java.WordCount;
import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.assertEquals;

/**
 * Test class to provide simple checks while coding - do not consider this a TDD suite.
 */
public class WordCountTest {

    @Test
    public void testSortUniqueWords() {
        String test = "A mate material may maybe right maybe";

        WordCount wc = new WordCount();

        wc.sortUniqueWords(test.toLowerCase().split(" +"));

        String [] result = wc.getFrequency().keySet().toArray(new String [0]);

        assertEquals(3, result.length);
        assertEquals("material", result[0]);
        assertEquals("maybe", result[1]);
        assertEquals("right", result[2]);
    }

    @Test
    public void testCountWords() {
        String test = "A mate material may maybe right maybe";

        WordCount wc = new WordCount();

        wc.countWords(test);

        Map<String, Integer> results = wc.getFrequency();

        assertEquals(1,(int)results.get("material"));
        assertEquals(2,(int)results.get("maybe"));
        assertEquals(1,(int)results.get("right"));
        assertEquals(null, results.get("mate"));
        assertEquals(null, results.get("a"));
        assertEquals(null, results.get("may"));
    }
}
