package pfb.anagrams

/**
 * An arrangement of characters which may
 * or may not be an English word.
 */
class Term(val text: String) {

    fun permutations(): Set<Term> {
        //Create a result set to which the permutations will be added.
        val result = mutableSetOf<Term>()
        //If the word has length 0 or 1, then the word itself is
        //the only permutation. Add this and return.
        if (text.length <= 1) {
            result.add(this)
            return result
        }
        //At this point we know that the length is at least two.
        //Get the first character of the word.
        val head = text[0]
        //Create a shortened word by removing the first character.
        val tail = tail()
        //Apply this method recursively to get the permutations
        //of the shortened word.
        val tailPermuations = tail.permutations()
        //For each possible insertion position,
        //for each word in the permutations of the shortened word,
        //create a word by inserting the first character at the
        //position, and add this to the result.
        for (i in 0..text.length - 1) {
            for (tailPermutation in tailPermuations) {
                result.add(tailPermutation.createNewWord(head, i))
            }
        }
        return result
    }

    fun tail(): Term {
        if (text == "") {
            return Term("")
        }
        return Term(text.substring(1))
    }

    fun createNewWord(newChar: Char, position: Int): Term {
        val before = text.substring(0, position)
        val after = text.substring(position)
        return Term(before + newChar + after)
    }

    override fun toString(): String {
        return text
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Term

        if (text != other.text) return false

        return true
    }

    override fun hashCode(): Int {
        return text.hashCode()
    }
}