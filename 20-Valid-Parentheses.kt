class Solution {
    fun isValid(s: String): Boolean {
        val brackets: Stack<Char> = Stack<Char>()
        s.forEach { bracket ->
            if (bracket.isOpenBracket()) {
                brackets.push(bracket)
                return@forEach
            }
            if (brackets.isEmpty()) return false
            if (!bracket.isMatchedWith(brackets.pop())) {
                return false
            }
        }
        if (brackets.isNotEmpty()) return false
        return true
    }
} 

private fun Char.isOpenBracket(): Boolean = this == '(' || this == '{' || this == '['

private fun Char.isMatchedWith(other: Char): Boolean {
    if (this == ')') return other == '('
    if (this == '}') return other == '{'
    if (this == ']') return other == '['
    return false
}