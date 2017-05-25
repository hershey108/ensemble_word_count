package main.java;

import java.util.Comparator;

/**
 * A comparator class to sort collections by length of the Strings in them, and alphabetically for any strings that are
 * the same length.
 */
public class SortByStringLengthComparator implements Comparator<String> {

    public int compare(String o1, String o2) {
        if (o1.length() != o2.length()) {
            return o2.length()-o1.length();
        }

        return o1.compareTo(o2);
    }
}
