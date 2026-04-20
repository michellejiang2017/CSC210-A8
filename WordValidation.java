import java.util.HashSet;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Store valid words and generate suggestions for misspelled words.
 */
public class WordValidation implements SpellingOperations {
  private HashSetDictionary dictionary;

  /**
   * Create a validator from a dictionary file.
   *
   * @param filename the file containing valid words
   */
  public WordValidation(String filename) {
    File words = new File(filename);
    try (Scanner myReader = new Scanner(words)) {

            while (myReader.hasNextLine()) {

                String line = myReader.nextLine();

                int spaceIndex = line.indexOf(" "); // ok idk lets sleep and work tmr

            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

  /**
   * Check whether the dictionary contains a word.
   *
   * @param query the word to check
   * @return true if the word is in the dictionary
   */
  public boolean containsWord(String query) {
    return false;
  }

  /**
   * Generate valid near misses for a query word.
   *
   * @param query the word to check
   * @return a set of valid suggestions that are one edit away
   */
  public Set<String> nearMisses(String query) {
    return new HashSet<>();
  }
}
