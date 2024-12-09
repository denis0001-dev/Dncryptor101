import Solver.Companion.ALPHABET_RUSSIAN
import kotlin.random.Random
import kotlin.random.nextInt

fun main() {
    val version = "1.2"
    val solver = Solver()
    println(
        """
            Dncryptor101 
            Version $version
            ------------------ 
        """.trimIndent()
    )
    while (true) {
        print(
            """
                Select an option:
                0. Exit
                1. Decrypt text
                2. Encrypt text
                3. About
                Type a number: 
            """.trimIndent()
        )
        val choice: Int
        try {
            choice = readln().toInt()
        } catch (_: NumberFormatException) {
            println("Try again.")
            continue
        }
        when (choice) {
            0 -> break
            1 -> {
                print("Enter a word to decrypt: ")
                val inp = readln()
                print("Shift (0/Enter if you don't know (list all variants)): ")
                var shift: Int
                while (true) {
                    try {
                        val inp1 = readln()
                        shift = if (inp1 == "") 0 else inp1.toInt()
                        break
                    } catch (e: NumberFormatException) {
                        println("Your input is not a number. Try again.")
                        continue
                    }
                }
                if (shift != 0) {
                    val word = solver.decrypt(inp, shift)
                    println("Your decrypted word: $word")
                    break
                }
                println("\nPossible variants:")
                val words = solver.decrypt(inp)
                var col = 1
                for (word in words) {
                    print(word)
                    col++
                    if (col == 3 + 1) {
                        col = 1
                        println()
                    } else {
                        print(" ")
                    }
                }
                break
            }
            2 -> {
                print("Type a word to encrypt: ")
                val inp = readln()
                print("Shift (0 to generate a random one): ")
                var shift: Int

                while (true) {
                    try {
                        shift = readln().toInt()
                        break
                    } catch (_: NumberFormatException) {
                        println("Your input is not a number. Try again.")
                        continue
                    }
                }
                if (shift == 0) {
                    shift = Random.nextInt(
                        -ALPHABET_RUSSIAN.length..ALPHABET_RUSSIAN.length
                    )
                    println("Your shift: $shift")
                }
                val word = solver.encrypt(inp, shift)
                println("Your encrypted word: $word")

                break
            }
            3 -> {
                println(
                    """
                        
                        A simple program to encrypt and decrypt text.
                        Version $version
                    """.trimIndent()
                )
                break
            }
        }
    }
}