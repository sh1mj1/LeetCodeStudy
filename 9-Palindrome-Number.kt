class Solution {
    fun isPalindrome(x: Int): Boolean {
        var target = x
        var reversed = 0

        while(target > 0) {
            reversed = reversed * 10 + target % 10
            target /= 10
        }
        return x == reversed
    }
}


/*

make the reversed number wihtout converting to String. 

let's suppose the x is 100021

var target = x
var reversed = 0

get the least digit value of the target.
and update reversed like:
    reversed = reversed * 10 + target % 10 
    target /= 10


then it's gon be like this for 10021

    reversed = 0 * 10 + 1 = 1
    target = 1002

    reversed = 1 * 10 + 2 = 12
    target = 100

    reversed = 12 * 10 + 0 = 120
    target = 10

    reversed = 120 * 10 + 0 = 1200
    target = 1

    reversed = 1200 * 10 + 0 = 12001
    target = 0



    then we can get the reversed for x.

    and if the reversed == x -> true





 */