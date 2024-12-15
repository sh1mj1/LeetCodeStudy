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
        val d3BeforeHead: ListNode = ListNode(0)
        var d3: ListNode = d3BeforeHead

        var carry = 0
        var d1 = l1
        var d2 = l2
        
        while( !(d1 == null && d2 == null) || carry != 0) {
            if(d1 == null) d1 = ListNode(0)
            if(d2 == null) d2 = ListNode(0)
            
            var sum = d1.`val` + d2.`val` + carry
            
            if(sum >= 10) {
                sum -= 10
                carry = 1
            } else {
                carry = 0
            }

            d3.next = ListNode(sum)

            d1 = d1.next
            d2 = d2.next
            d3 = d3.next
        }
        return d3BeforeHead.next
    }
}

/*
ex1:
    2, 4, 3  => 342
    5, 6, 4  => 465
    7, 0, 8  => 807


well, the digits are store in reverse order.
and it's very similiar with the way we caculate the numbers in real worl.d

in ex3:
     l1 = [9,9,9,9,9,9,9],  => 9999999
     l2 = [9,9,9,9]         => 0009999
     
each digits have to added with the carry.
and carry can be 0 or 1.

let's suppose in example3
    carry = 0
    while(d1 != nul && d2 != null){
        if d1 == null: d1 = 0
        if d2 == null: d2 = 0

        sum = d1 + d2
            check sum is greater than 10 
            if right, carry = 1, sum -= 10
            otherwise, carry = 0,
        d3 = sum
        d1 = d1.next
        d2 = d2.next
        d3 = d3.next
    }
        
return d3

ok let me write the code.




 */