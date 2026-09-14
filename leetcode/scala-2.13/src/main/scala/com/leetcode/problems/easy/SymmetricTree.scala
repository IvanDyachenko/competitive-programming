package com.leetcode.problems.easy

/** 101. Symmetric Tree
  * https://leetcode.com/problems/symmetric-tree/
  */
object SymmetricTree {
  import scala.collection.mutable.ArrayDeque

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value

    var left: TreeNode  = _left
    var right: TreeNode = _right
  }

  def isSymmetric(root: TreeNode): Boolean =
    if (root == null) true
    else {
      val deque = ArrayDeque(root.left, root.right)

      @annotation.tailrec
      def go: Boolean =
        if (deque.isEmpty) true
        else {
          (deque.removeHead(), deque.removeHead()) match {
            case (null, null)                                 => go
            case (null, _) | (_, null)                        => false
            case (node1, node2) if node1.value != node2.value => false
            case (node1, node2)                               =>
              deque.append(node1.left, node2.right, node1.right, node2.left)
              go
          }
        }

      go
    }

}
