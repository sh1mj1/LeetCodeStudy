class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numToIdxes = HashMap<Int, Int>(nums.size)

        for( (idx, num) in nums.withIndex() ) {
            val diff = target - num

            numToIdxes[diff]?.let {
                return intArrayOf(idx, it)
            }
            numToIdxes[num] = idx
        }
        throw IllegalArgumentException(\no answer\)
    }
}


/* 
create a hash map to store the value of each number and its index.
Iterate through the array, and for each number:
    compute the difference (target - nums[i]).
    check if this diff is in the hash map.
        if found, return the current index and the index of idff.
        otherwise, store the number and its index in the hash map for future lookups.

The problem can be solved optimally in O(n) time using a hash map.
this avoids the need for sorting and simplifies the logic.
 */