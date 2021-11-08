package com.leetcode.problems.easy

/** 167. Two Sum II - Input Array Is Sorted
  * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
  */
object TwoSumIIInputArrayIsSorted {

  def twoSum(xs: Array[Int], target: Int): Array[Int] = {
    @annotation.tailrec
    def go(left: Int, right: Int): Array[Int] =
      target.compare(xs(left) + xs(right)) match {
        case 0                => Array(left + 1, right + 1)
        case sign if sign < 0 => go(left, right - 1)
        case _                => go(left + 1, right)
      }

    go(0, xs.length - 1)
  }

}
