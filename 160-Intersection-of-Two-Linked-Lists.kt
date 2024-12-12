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
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        if(headA == null || headB == null) return null
        var (currentA, currentB) = getStartNodes(headA, headB)

        while(currentA != currentB) {
            currentA = currentA.next ?: return null
            currentB = currentB.next ?: return null
        }
        return currentA
    }

    fun getStartNodes(headA: ListNode, headB: ListNode): Pair<ListNode, ListNode> {
        var currentA = headA
        var currentB = headB

        val aLength = headA.length()
        val bLength = headB.length()

        if(aLength > bLength) {
            repeat(aLength - bLength) {
                currentA = currentA.next
            }
        }
        if(bLength > aLength) {
            repeat(bLength - aLength) {
                currentB = currentB.next
            }
        }
        return Pair(currentA, currentB)
    }

}

fun ListNode.length() : Int {
    if (this == null) return 0
    var idx = 0
    var currentNode: ListNode? = this
    while(currentNode != null) {
        idx++
        currentNode = currentNode.next
    }
    return idx
}
