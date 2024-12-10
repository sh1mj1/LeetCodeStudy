/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        return recursiveTraverse(root, mutableListOf<Int>())
        // return iterativeTraverse(root)
    }

    fun recursiveTraverse(node: TreeNode?, nodes: MutableList<Int>): MutableList<Int> {
        if(node == null) return nodes
        nodes.add(node.`val`)
        return recursiveTraverse(node.right, recursiveTraverse(node.left, nodes))
    }

    fun iterativeTraverse(root: TreeNode?): List<Int> {
        if(root == null) return emptyList()
        val stack: Stack<TreeNode> = Stack()
        stack.push(root)
        val nodes = mutableListOf<Int>()
        while(stack.isNotEmpty()) {
            val currentNode = stack.pop().also { nodes.add(it.`val`) }
            currentNode.right?.let { stack.push(it) }
            currentNode.left?.let { stack.push(it) }
        }
        return nodes
    }

}

/*
preorder. that is, MLR

i can solve it with two ways: recursivley, and iteratively.
let me see the constraints.

the number of nodes in the tree is in the range [0 , 100].
so there is a no possibility for callstackoverflow exception.
so i'mm gonna solve it with recursively. 
because that's very easy way to implement with less code.

    Follow up: Recursive solution is trivial, could you do it iteratively?
Yes, sure
    then, i can use the iterative way using loop.

fist, i make the queue, and add the root node in the queue.

and travers the queue until it become empty.
    and in the loop.
    poll currentNode. and add its value in the list.
    add currentNode.left
    add currentNode.right
    
That's it.
this traverse strategy is BFS.

fun iterativeTraverse(root: TreeNode?): List<Int> {
        if(root == null) return emptyList()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        val nodes = mutableListOf<Int>()
        while(queue.isNotEmpty()) {
            val currentNode = queue.poll().also {nodes.add(it.`val`)}
            currentNode.left?.let { queue.add(it) }
            currentNode.right?.let { queue.add(it) }
        }
        return nodes
    }

Oh, it does not pass the case2.

Let me check..
ah, this is not preorder. because it is bfs. 
then i had to use another way.

i can use stack and it is DFS.

 */