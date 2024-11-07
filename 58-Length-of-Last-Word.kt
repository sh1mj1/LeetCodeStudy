class Solution {
    fun lengthOfLastWord(s: String): Int {
        // return s.trim().split(\ \).last().length
        var index = s.length - 1
        var length = 0

        // remove the last blank
        while(index >= 0 && s[index] == ' '){
            index--
        }

        while(index >= 0 && s[index] != ' ') {
            index--
            length++
        }
        return length
    }
}
