class Solution {
    fun convertToTitle(columnNumber: Int): String = buildString {
        var n = columnNumber
        while (n > 0) {
            n = n - 1
            val mod = n % 26
            insert(0, mod.toAlphabet())
            n = n / 26
        }
    }
}

private fun Int.toAlphabet(): Char = (this + 'A'.toInt()).toChar()