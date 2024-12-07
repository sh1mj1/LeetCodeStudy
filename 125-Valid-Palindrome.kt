class Solution {
    fun isPalindrome(s: String): Boolean {
        var sIdx = 0
        var eIdx = s.length - 1

        while(sIdx < eIdx) {
            while(sIdx < eIdx && !s[sIdx].isLetterOrDigit()){
                sIdx++
            }
            while(sIdx < eIdx && !s[eIdx].isLetterOrDigit()) {
                eIdx--
            }
            
            if(s[sIdx].toLowerCase() != s[eIdx].toLowerCase()) return false

            sIdx++
            eIdx--
        }        
        return true
    }
}

