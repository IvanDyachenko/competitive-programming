package com.leetcode.problems.easy

/** 206. Reverse Linked List
  * https://leetcode.com/problems/reverse-linked-list/
  */
object ReverseLinkedList {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int         = _x
  }

  def reverseList(head: ListNode): ListNode = {
    @annotation.tailrec
    def go(node: ListNode, result: ListNode = null): ListNode =
      if (node == null) result
      else go(node.next, new ListNode(node.x, result))

    go(head)
  }
}
