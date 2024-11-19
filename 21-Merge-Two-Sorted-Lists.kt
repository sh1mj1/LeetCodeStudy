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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1 == null) return list2
        if(list2 == null) return list1

        val dummy = ListNode(-1)
        var current = dummy

        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            if(l1.`val` <= l2.`val`) {
                current.next = l1
                l1 = l1.next
            } else {
                current.next = l2
                l2 = l2.next
            }
            current = current.next!!
        }

        if(l1 != null) {
            current.next = l1
            return dummy.next
        }
        if(l2 != null) {
            current.next = l2
            return dummy.next
        }
        return dummy.next
    }
}

/*
we need to merge two sorted linked lists into one sorted linked list.

dummy node: simpilfing the process of merging. next of the dummy node == head of the merged linked list.

Traverse both lists and compare the nodes.
    Add the smaller node to the merged list.
    Also, Move the pointer of the selected list forward.
    
    Once one list is exhausted, append the remaining part of the other list.

Psudo code
1. Create DUMMY_NODE
2. CURRENT pointer to build the new list.
3. Travers both list1 and list2:
    if(list1.val < list2.val)
        set current.next to list1 and move list1 forward
    else
        se current.next to list2 and move list2 forward.

4. After the loop, append the remaining nodes of either list1 or list2
5. Return dummy.next as the head of the merged list.

 */