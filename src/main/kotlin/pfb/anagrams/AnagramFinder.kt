package pfb.anagrams

import java.nio.file.Paths


/**
 * Finds the anagrams of a word.
 */
fun main(args: Array<String>) {
    val path = Paths.get("src/main/resources/books/english.txt")
    val dictionary = FileBasedDictionary(path)
    //Create a Word from some initial English word.
    val str = "regal"
    if (!dictionary.contains(str)) {
        System.out.println("Not in dictionary: " + str);
    }
    val word = Term(str);
    //Get all rearrangements of the letters in this word.
    val anagrams = word.permutations()
    //For each of these...
    for (w in anagrams) {
        //...if it is in the dictionary...
        if (dictionary.contains(w.text)) {
            //...print it out.
            println(w.text)
        }
    }
}