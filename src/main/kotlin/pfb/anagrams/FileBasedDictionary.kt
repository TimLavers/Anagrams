package pfb.anagrams

import java.nio.file.Files
import java.nio.file.Path


/**
 * Checks words for inclusion in a list of words read from a file.
 * The file format is one word per line.
 */
class FileBasedDictionary(pathToFile: Path) {

    val words = mutableSetOf<String>()
    init {
        val lines = Files.readAllLines(pathToFile)
        for (line in lines) {
            words.add(line)
        }
    }

    operator fun contains(string: String): Boolean {
        return words.contains(string)
    }
}