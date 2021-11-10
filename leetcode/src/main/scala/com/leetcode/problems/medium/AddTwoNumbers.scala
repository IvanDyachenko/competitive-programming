package com.leetcode.problems.medium

/** 2. Add Two Numbers
  * https://leetcode.com/problems/add-two-numbers/
  */
object AddTwoNumbers {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var x: Int         = _x
    var next: ListNode = _next
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {

    @annotation.tailrec
    def go(first: ListNode, second: ListNode, accumulator: Int = 0, result: ListNode = null): ListNode =
      if (first == null && second == null)
        if (accumulator == 0) result else new ListNode(accumulator, result)
      else if (first == null) {
        val quotient = (accumulator + second.x) / 10
        val reminder = (accumulator + second.x) % 10
        go(first, second.next, quotient, new ListNode(reminder, result))
      } else if (second == null) {
        val quotient = (accumulator + first.x) / 10
        val reminder = (accumulator + first.x) % 10
        go(first.next, second, quotient, new ListNode(reminder, result))
      } else {
        val quotient = (accumulator + first.x + second.x) / 10
        val reminder = (accumulator + first.x + second.x) % 10
        go(first.next, second.next, quotient, new ListNode(reminder, result))
      }

    @annotation.tailrec
    def reverse(list: ListNode, result: ListNode = null): ListNode =
      if (list == null) result else reverse(list.next, new ListNode(list.x, result))

    reverse(go(l1, l2))
  }

}
