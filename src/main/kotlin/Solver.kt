class Solver {
    companion object {
        const val ALPHABET_RUSSIAN = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
        const val ALPHABET_ENGLISH = "abcdefghijklmnopqrstuvwxyz"

        val ALPHABET_RUSSIAN_SEQ = InfiniteList(*ALPHABET_RUSSIAN.toCharArray().toTypedArray())
        val ALPHABET_ENGLISH_SEQ = InfiniteList(*ALPHABET_ENGLISH.toCharArray().toTypedArray())

    }
}