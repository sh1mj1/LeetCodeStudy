class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var s = 0
        var e = nums.size
        while (s < e) {
            if (nums[s] == `val`) {
                nums[s] = nums[e -1]
                e--
            } else {
                s++
            }
        }
        return e
    }

}
