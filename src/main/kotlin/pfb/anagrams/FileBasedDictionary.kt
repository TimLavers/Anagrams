package pfb.anagrams

import java.nio.file.Path

/**
 * Checks words against a list of words read
 * from a file in which there is one word per line.
 */
class FileBasedDictionary(pathToFile: Path) {

    fun contains(string: String): Boolean {
        return false
    }
}