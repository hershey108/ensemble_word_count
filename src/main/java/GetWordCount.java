package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Main class to run word count. Either call with no parameter and then paste in a string of text, or call with one
 * parameter which is a path to a file. It will then process and print out the count of each unique word in the text.
 */
public class GetWordCount {

    public static void main(String[] args) {

        String text;

        if (args.length == 0) {
            Scanner s = new Scanner(System.in);
            System.out.println("Please paste your string in as a single line and press enter:");

            text = s.nextLine();
        } else {
            text = readInFile(args[0]);
            if (text == null) {
                System.out.println("Apologies, there was an error while accessing your file. Please confirm the path.");
                return;
            }
        }

        WordCount wc = new WordCount();

        wc.countWords(text);

        wc.publishCount();


    }

    private static String readInFile(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            System.err.println("Error while accessing the file.");
            e.printStackTrace(System.err);
        }
        return null;
    }

}
