package pfb.anagrams

import java.nio.file.Path

/**
 * Checks words for inclusion in a list of words read from a file.
 * The file format is one word per line.
 */
class FileBasedDictionary(pathToFile: Path) {

    fun contains(string: String): Boolean {
        return false
    }
}