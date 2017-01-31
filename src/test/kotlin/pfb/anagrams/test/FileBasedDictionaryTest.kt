package pfb.anagrams.test

import org.junit.Assert
import org.junit.Test
import pfb.anagrams.FileBasedDictionary
import java.nio.file.Paths

class FileBasedDictionaryTest {
    @Test
    fun containsTest() {
        val path = Paths.get("src/test/resources/books/FiveWords.txt")
        val dictionary = FileBasedDictionary(path)
        Assert.assertTrue(dictionary.contains("aardvark"))
        Assert.assertTrue(dictionary.contains("bat"))
        Assert.assertTrue(dictionary.contains("cat"))
        Assert.assertTrue(dictionary.contains("dog"))
        Assert.assertTrue(dictionary.contains("eel"))

        Assert.assertFalse(dictionary.contains("aardwolf"))
        Assert.assertFalse(dictionary.contains("zebra"))
    }
}