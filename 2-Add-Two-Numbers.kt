/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return addedTwoNumbers(l1, l2, 0)
    }

    fun addedTwoNumbers(l1: ListNode?, l2: ListNode?, carry: Int = 0): ListNode? {
        if(l1 == null && l2 == null && carry == 0) return null
        val sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry
        return ListNode(sum % 10).apply {
            next = addedTwoNumbers(
                l1 = l1?.next, 
                l2 = l2?.next,
                carry = sum / 10
            )
        }
    }
}


/*
recursive way



 */