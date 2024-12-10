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
    fun hasCycle(head: ListNode?): Boolean {
        var currentNode = head
        var fastNode = head?.next

        while(fastNode != null && currentNode != fastNode) {
            currentNode = currentNode!!.next
            fastNode = fastNode.next?.next
        }

        return fastNode != null
    }
}

/*
Ok, I have to check whether there is a cycle or not.
in example 1 the tail is the node whose value is -4.
and the next pointer of tail is the node whose value is 2.
ok,  and let me check the constraints.

The linked list has an only one pointer whose variable name is next.
and the max number of the nodes is 10^4. 

So, if i traverse all the nodes, the time complexity is O(10^4).
and i need to do it.

In this problem, i can solve it with bruth force approach.
Because we don't know when the cycle will approach.

Then i define the visited list,
and traverse the nodes, checking i there is a node that i already visit.
we don't knwo how many nodes we have.
so the searching is like this:
    1. get next Node
    2. check the next Node is null
        true: return false
    2. check the current Node is in visited list.
        true: return true
        false: add the current Node in visited.
    3. add the current Node in the visited list.

18m solve

    Follow up: Can you solve it using O(1) (i.e. constant) memory?
Well.. that means i can't sovle this problem with a visited list.
Is there a condition that the `val` of nodes are all differnt each other?
if it is, then i can solve it with xor operation. 
but i can't use it. because there is a case when `val` of nodes are same in different nodes.

    Interviewer: You can use the two pointer

oh, i get it.
then i can use the floyd's cycle detection algorithm.
let's make the two pointers.

one: fastNode
the other: currentNode.

at first, fastNode and currentNode is same.
and make a loop until (currentNode is not null && curretNode != fastNode)

move the currentNode to the next. (currentNode move just one-by-one.)
move the fastNode to the next.next. (fastNode move twice at the only once time)


if the fastNode is null: return false
if the currentNode same with fastNode: return true.


Then i can solve it with constant memory.

*/