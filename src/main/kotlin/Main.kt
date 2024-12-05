import Solver.Companion.ALPHABET_ENGLISH
import Solver.Companion.ALPHABET_ENGLISH_SEQ
import Solver.Companion.ALPHABET_RUSSIAN
import Solver.Companion.ALPHABET_RUSSIAN_SEQ

fun main() {
    print(
        """
            SuperDecryptor 1.0
            ------------------
            Enter a word to decrypt: 
        """.trimIndent()
    )
    val inp = readln()
    println("\nPossible variants:")
    val words = mutableListOf<String>()
    for (shift in -ALPHABET_RUSSIAN.length until ALPHABET_RUSSIAN.length) {
        var word = ""
        for (letter in inp) {
            var index = ALPHABET_ENGLISH.indexOf(letter)
            var print: Char
            if (index == -1) {
                index = ALPHABET_RUSSIAN.indexOf(letter)
                print = if (index == -1) {
                    letter
                } else {
                    ALPHABET_RUSSIAN_SEQ[index + shift]
                }
            } else {
                print = ALPHABET_ENGLISH_SEQ[index + shift]
            }
            word += print
        }
        if (!words.contains(word) && word != inp) {
            words += word
        }
    }

    for (word in words) {
        println(word)
    }
}