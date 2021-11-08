package com.leetcode.problems.easy

/** 26. Remove Duplicates from Sorted Array
  * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
  */
object RemoveDuplicatesFromSortedArray {

  def removeDuplicates(xs: Array[Int]): Int =
    xs.length - xs.indices.drop(1).foldLeft(0) {
      case (k, i) if xs(i) == xs(i - 1) => k + 1
      case (k, i)                       =>
        xs(i - k) = xs(i)
        k
    }

}
