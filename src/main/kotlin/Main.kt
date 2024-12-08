fun main() {
    val solver = Solver()
    println(
        """
            Dncryptor101 
            Version 1.1
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
                println("\nPossible variants:")
                val words = solver.decrypt(inp)

                for (word in words) {
                    println(word)
                }
                break
            }
            2 -> {
                println("Not implemented yet.")
                break
            }
            3 -> {
                println(
                    """
                        
                        A simple program to encrypt and decrypt text.
                        Version 1.1
                    """.trimIndent()
                )
                break
            }
        }
    }
}