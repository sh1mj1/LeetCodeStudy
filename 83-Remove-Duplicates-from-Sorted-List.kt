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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if(head == null || head?.next == null) return head

        var now = head
        while(now?.next != null) {
            if(now.nextValueIsSame()) {
                now.next = now.next.next
            }else {
                now = now?.next
            }
        }
        return head
    }
}

fun ListNode.nextValueIsSame(): Boolean {
    val now = this.`val`
    val nextValue = this.next?.`val`
    return now == nextValue
}
