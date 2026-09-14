package com.leetcode.problems.medium

/** 1493. Longest Subarray of 1's After Deleting One Element
  * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
  */
object LongestSubarrayOf1sAfterDeletingOneElement {

  def longestSubarray(xs: Array[Int]): Int = {
    val longest = xs
      .foldLeft((0, 0, 0)) {
        case ((longest, previous, current), 1) => (longest max (previous + current + 1), previous, current + 1)
        case ((longest, _, 0), _)              => (longest, 0, 0)
        case ((longest, _, current), _)        => (longest, current, 0)
      }
      ._1

    if (longest == xs.length) longest - 1 else longest
  }

}
