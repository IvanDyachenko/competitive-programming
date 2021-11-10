package com.leetcode.problems.medium

import scala.collection.mutable.HashMap

/** 560. Subarray Sum Equals K
  * https://leetcode.com/problems/subarray-sum-equals-k/
  */
object SubarraySumEqualsK {

  def subarraySum(nums: Array[Int], goal: Int): Int = {
    val prefixes = nums.scanLeft(0L)(_ + _)

    val table = HashMap.empty[Long, Int]

    prefixes.foldLeft(0) { (count, right) =>
      val left  = right - goal
      val delta = table.getOrElse(left, 0)
      table.updateWith(right)(_.orElse(Some(0)).map(_ + 1))
      count + delta
    }
  }

}
