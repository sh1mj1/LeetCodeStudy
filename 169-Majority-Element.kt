class Solution {
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var candidate = 0
        nums.forEach { num -> 
            if(count == 0) candidate = num
            if(num == candidate) count++ else count --
        }
        return candidate
    }
}
