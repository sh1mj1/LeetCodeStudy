class Solution {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            result = (result xor num)
        }
        return result
    }
}

/*
The goal is to find the single number in an array where every other number appears twice.
The constraints are:
Linear runtime complexity O(n)
Constant extra space O(1)   


Exploring the XOR Approach

XOR(^) is a bitwise operator with the following properties:
\ta ^ a = 0 (XORing the same number results in 0)
\ta ^ 0 = a (XORing with 0 leaves the number unchanged)
XOR is **commutative and associative**, so the order doesn't matter.

Plan:
Initialize a variable result with 0.
Traverse the array, XORing each element with result.
At the end of the traversal, result will contain the single number.

Let's suppose the numbers are 1, 2, ,3, 2, 1
we traverse the numbers, xoring each element with result.
then the equation is like this: 
\t0 xor 1 xor 2 xor 3 xor 2 xor 1

And i said XOR is commutative and associative!
so:
    0 xor 1 xor 2 xor 3 xor 2 xor 1 ==
    0 xor (1 xor 1) xor 3 xor (2 xor 2) ==
    0 xor 0 xor 3 xor 0 ==
    3

 */