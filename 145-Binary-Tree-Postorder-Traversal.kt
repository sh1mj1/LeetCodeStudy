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
    fun postorderTraversal(root: TreeNode?): List<Int> {
        return traversedRecursively(root, mutableListOf<Int>())
        // return traversedIteratively(root)
    }

    fun traversedRecursively(node: TreeNode?, traversedValues: MutableList<Int>): List<Int> {
        if(node == null) return traversedValues
        node.left.let { traversedRecursively(it, traversedValues) }
        node.right.let { traversedRecursively(it, traversedValues) }
        traversedValues.add(node.`val`)
        return traversedValues
    }

    fun traversedIteratively(node: TreeNode?): List<Int> {
        val traversedValues = LinkedList<Int>()
        if(node == null) return traversedValues
        val stack: Stack<TreeNode> = Stack<TreeNode>().apply {
            push(node)
        }

        while(stack.isNotEmpty()) {
            val currentNode = stack.pop()
            traversedValues.add(0, currentNode.`val`)
            currentNode.left?.let { stack.push(it) }
            currentNode.right?.let { stack.push(it) }
        }
        return traversedValues
    }
}

/*
Ok, we can solve this with iterative way.
this is postOrder so, LRM
So, the root node has to be added at last.
Then... it looks quite difficult.
But if i add the the `val` of node at the first index of list.
Then it gets quite simple to solve this.

And add the node in the first index can have big resource if i use the ArrayList.
So i'll use the LinkedList.

 */