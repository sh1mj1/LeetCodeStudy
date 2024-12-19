class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val strsSize = strs.size
        val firstString = strs[0]
        if (strsSize == 1) return firstString

        val prefix = StringBuilder()
        
        for(i in firstString.indices) {
            val currentCharacter = firstString[i]

            for(str in strs) {
                if(i >= str.length || str[i] != currentCharacter) return prefix.toString()
            }
            prefix.append(currentCharacter)
        }

        return prefix.toString()
    }
}
