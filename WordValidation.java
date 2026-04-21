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
    Scanner file = null;
    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);
    }

    while (file.hasNextLine()) {
      String word = file.nextLine().replaceAll("[^a-zA-Z]", "").toLowerCase();
      dictionary.add(word);
    }

    file.close();
  }
    

  /**
   * Check whether the dictionary contains a word.
   *
   * @param query the word to check
   * @return true if the word is in the dictionary
   */
  public boolean containsWord(String query) {
    query = query.replaceAll("[^a-zA-Z]", "").toLowerCase();
    if (this.dictionary.contains(query)) { 
      return true; 
    } else {
      return false;
    }
  }

  /**
   * Generate valid near misses for a query word.
   *
   * @param query the word to check
   * @return a set of valid suggestions that are one edit away
   */
  public Set<String> nearMisses(String query) {
    HashSet<String> returns = new HashSet<String>(); 
    returns.addAll(deletions(query));
    returns.addAll(insertions(query));
    returns.addAll(substitutions(query));
    returns.addAll(transpositions(query));
    returns.addAll(splits(query));

    return returns;
  }

  /**
   * Generate valid near misses for a query word that are two edits away. Delete one letter from the word.
   *
   * @param query the word to check
   * @return a set of valid suggestions that are two edits away
   */
  public HashSet<String> deletions(String query) {
    HashSet<String> returns = new HashSet<String>();
      for (int i = 0; i < query.length(); i++) {
        StringBuilder sb = new StringBuilder(query);
        sb.deleteCharAt(i);
        String candidate = sb.toString(); 
        if (this.dictionary.contains(candidate)) {
          returns.add(candidate);
        }
      }
    return returns;
  }

  /**
   * Generate valid near misses for a query word that are one edit away. Insert one letter into the word at any point.
   *
   * @param query the word to check
   * @return a set of valid suggestions that are one edit away
   */
  public HashSet<String> insertions(String query) {
    HashSet<String> returns = new HashSet<String>();
      for (int i = 0; i < query.length(); i++) {
        StringBuilder sb = new StringBuilder(query);
        for (char c = 'a'; c <= 'z'; c++) {
          sb.insert(i, c);
          String candidate = sb.toString(); 
          if (this.dictionary.contains(candidate)) {
            returns.add(candidate);
        }
        sb.deleteCharAt(i);
        }
      }
    return returns;
  }

  /**
   * Generate valid near misses for a query word that are one edit away.
   *
   * @param query the word to check
   * @return a set of valid suggestions that are one edit away
   */
  public HashSet<String> substitutions(String query) {
    HashSet<String> returns = new HashSet<String>();
      for (int i = 0; i < query.length(); i++) {
        StringBuilder sb = new StringBuilder(query);
        for (char c = 'a'; c <= 'z'; c++) {
          sb.setCharAt(i, c);
          String candidate = sb.toString(); 
          if (this.dictionary.contains(candidate)) {
            returns.add(candidate);
          }
        }
      }
    return returns;
  }

  /**
   * Generate valid near misses for a query word that are one edit away.
   *
   * @param query the word to check
   * @return a set of valid suggestions that are one edit away
   */
  public HashSet<String> transpositions(String query) {
    HashSet<String> returns = new HashSet<String>();
      for (int i = 0; i < query.length(); i++) {
        StringBuilder sb = new StringBuilder(query);
        for (char c = 'a'; c <= 'z'; c++) {
          char temp = sb.charAt(i);
          sb.setCharAt(i, c);
          sb.setCharAt((i + 1) % query.length(), temp);
          String candidate = sb.toString(); 
          if (this.dictionary.contains(candidate)) {
            returns.add(candidate);
          }
        }
      }
    return returns;
  }

  /**
   * Generate valid near misses for a query word that are one edit away.
   *
   * @param query the word to check
   * @return a set of valid suggestions that are one edit away
   */
  public HashSet<String> splits(String query) {
    HashSet<String> returns = new HashSet<String>();
      for (int i = 1; i < query.length(); i++) {
        String left = query.substring(0, i);
        String right = query.substring(i);
        if (this.dictionary.contains(left) && this.dictionary.contains(right)) {
          returns.add(left + " " + right);
        }
      }
    return returns;
  }
}