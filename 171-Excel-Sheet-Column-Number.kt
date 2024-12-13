class Solution {
    fun titleToNumber(columnTitle: String): Int {
        var result = 0
        for (char in columnTitle) {
            val digit = char.alphabetToNumber()
            result = result * 26 + digit
        }
        return result
    }
}

private fun Char.alphabetToNumber(): Int = this.toInt() - 'A'.toInt() + 1