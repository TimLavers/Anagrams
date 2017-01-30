package pfb.anagrams.test

import org.junit.Assert
import org.junit.Test
import pfb.anagrams.Term

class TermTest {

    @Test fun permutationsWhenEmpty() {
        val empty = Term("")
        val permutations = empty.permutations()
        Assert.assertEquals(1, permutations.size)
        Assert.assertTrue(permutations.contains(Term("")))
    }

    @Test
    fun permutationsFromLengthOneTerm() {
        val a = Term("a")
        val permutations = a.permutations()
        Assert.assertEquals(1, permutations.size)
        Assert.assertTrue(permutations.contains(Term("a")))
    }

    @Test
    fun permutationsFromLengthTwoTerm() {
        val ab = Term("ab")
        val permutations = ab.permutations()
        Assert.assertEquals(2, permutations.size)
        Assert.assertTrue(permutations.contains(Term("ab")))
        Assert.assertTrue(permutations.contains(Term("ba")))
    }

    @Test
    fun tailTest() {
        val empty = Term("")
        Assert.assertEquals(empty, empty.tail())
        val a = Term("a")
        Assert.assertEquals(empty, a.tail())
        val anaconda = Term("anaconda")
        Assert.assertEquals(Term("naconda"), anaconda.tail())
    }

    @Test
    fun createNewTermFromEmptyTest() {
        val empty = Term("")
        Assert.assertEquals(Term("a"), empty.createNewWord('a', 0))
    }

    @Test
    fun createNewWordFromLengthOneTerm() {
        val x = Term("x")
        Assert.assertEquals(Term("ax"), x.createNewWord('a', 0))
        Assert.assertEquals(Term("xa"), x.createNewWord('a', 1))
    }

    @Test
    fun permutationsFromLengthThreeTerm() {
        val ab = Term("abc")
        val permutations = ab.permutations()
        Assert.assertEquals(6, permutations.size.toLong())
        Assert.assertTrue(permutations.contains(Term("abc")))
        Assert.assertTrue(permutations.contains(Term("acb")))
        Assert.assertTrue(permutations.contains(Term("bac")))
        Assert.assertTrue(permutations.contains(Term("bca")))
        Assert.assertTrue(permutations.contains(Term("cab")))
        Assert.assertTrue(permutations.contains(Term("cba")))
    }

    @Test
    fun permutationsWithRepeatedLetters() {
        val abba = Term("abba")
        //aabb, abab, abba, baab, baba, bbaa
        val permutations = abba.permutations()
        Assert.assertEquals(6, permutations.size.toLong())
        Assert.assertTrue(permutations.contains(Term("aabb")))
        Assert.assertTrue(permutations.contains(Term("abab")))
        Assert.assertTrue(permutations.contains(Term("abba")))
        Assert.assertTrue(permutations.contains(Term("baab")))
        Assert.assertTrue(permutations.contains(Term("baba")))
        Assert.assertTrue(permutations.contains(Term("bbaa")))
    }

    @Test
    fun toStringTest() {
        val term = Term("cat")
        Assert.assertEquals("cat", term.toString())
    }

    @Test
    fun equalsTest() {
        val cat = Term("cat")
        val dog = Term("dog")
        val feline = Term("cat")
        Assert.assertTrue(cat == feline)
        Assert.assertFalse(cat == dog)
    }

    @Test
    fun hashCodeTest() {
        val cat = Term("cat")
        val feline = Term("cat")
        Assert.assertTrue(cat.hashCode() == feline.hashCode())
    }
}