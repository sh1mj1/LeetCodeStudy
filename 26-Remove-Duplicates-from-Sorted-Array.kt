class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var min = nums.first() - 1 ?: return 0
        var idx = 0

        for( i in 0 .. nums.size -1) {
            val current = nums[i] // 1
            
            if(current > min) {
                nums[idx] = current
                idx++
                min = current
            }
        }
        
        return idx
    }
}
