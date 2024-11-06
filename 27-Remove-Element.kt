class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
    var k = 0
    var startIdx = 0
    var endIdx = nums.size -1 

    while(startIdx <= endIdx) {
        if(nums[startIdx] == `val`) {
            k++
            // swap
            val temp = nums[startIdx]
            nums[startIdx] = nums[endIdx]
            nums[endIdx] = temp
            endIdx--
        }else {
            startIdx++
        }
    }
    return nums.size - k
    }
}