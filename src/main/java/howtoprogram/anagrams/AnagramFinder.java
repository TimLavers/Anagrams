package howtoprogram.anagrams;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Finds the anagrams of a word.
 */
public class AnagramFinder {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/books/english.txt");
        FileBasedDictionary dictionary = new FileBasedDictionary(path);
        String str = "battle";
        if (!dictionary.contains(str)) {
            System.out.println("Not in dictionary: " + str);
        }
        Word word = new Word(str);
        Set<Word> anagrams = word.permutations();
        SortedSet<String> found = new TreeSet<>();
        for (Word w : anagrams) {
            if (dictionary.contains(w.text())) {
                found.add(w.text());
            }
        }
        System.out.println("found = " + found);

    }
}