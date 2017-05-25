package main.java;

import java.util.*;

/**
 * A word counter that will track and count unique words in some given text. It also filters out any words that are
 * substrings of other words in the text.
 */
public class WordCount {

    // The map that tracks the words and their frequency within the given text
    private Map<String,Integer> frequency;

    public WordCount() {
        frequency = new LinkedHashMap<String,Integer>();
    }

    /**
     * Accepts the text to be analysed. Retrieves the sorted unique words and then counts them.
     * @param text
     */
    public void countWords(String text) {

        String [] textArray = text.toLowerCase().split(" +");

        sortUniqueWords(textArray);

        for (String word : textArray) {
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word)+1);
            }
        }
    }

    /**
     * Sorts and filters the provided String array, and updates the frequency field with the final list of words.
     * @param textArray
     */
    public void sortUniqueWords(String [] textArray) {
        List<String> words = new ArrayList<String>();
        words.addAll(new HashSet<String>(Arrays.asList(textArray)));

        Collections.sort(words, new SortByStringLengthComparator());

        int length = words.size();

        // Loop through the collection. As the words are sorted by length in descending order, earlier words can never
        // be a substring of later words.
        for (int i = 0; i < length; i++ ) {
            for (int j = i+1; j < length; j++) {
                if (words.get(i).indexOf(words.get(j)) != -1) {
                    words.remove(j);
                    length--;
                    j--;
                }
            }

            // We know i is safe, we can put it in our frequency map and avoid another loop
            frequency.put(words.get(i),0);
        }

    }

    public void publishCount() {
        for (Map.Entry<String, Integer> pair : frequency.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
    }


    public Map<String,Integer> getFrequency() {
        return frequency;
    }
}
