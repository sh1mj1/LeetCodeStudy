class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        var combinations = listOf(\\)

        for (digit in digits) {
            val letters = digitToLetters[digit] ?: error(\invalid input\)
            val newCombinations = mutableListOf<String>()

            for (combination in combinations) {
                for (letter in letters) {
                    newCombinations.add(combination + letter)
                }   
            }
            combinations = newCombinations
        }
        return combinations
    }
}

private val digitToLetters = mapOf(
    '2' to \abc\,
    '3' to \def\,
    '4' to \ghi\,
    '5' to \jkl\,
    '6' to \mno\,
    '7' to \pqrs\,
    '8' to \tuv\,
    '9' to \wxyz\,
)
