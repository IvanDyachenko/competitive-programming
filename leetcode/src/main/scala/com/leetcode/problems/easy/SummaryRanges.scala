package com.leetcode.problems.easy

/** 228. Summary Ranges
  * https://leetcode.com/problems/summary-ranges/
  */
object SummaryRanges {

  def summaryRanges(xs: Array[Int]): List[String] =
    xs.foldLeft(List.empty[(Int, Int)]) {
      case ((a, b) :: ts, x) if x == b + 1 => (a, x) :: ts
      case (ts, x)                         => (x, x) :: ts
    }.map {
      case (a, b) if a != b => s"$a->$b"
      case (a, _)           => s"$a"
    }.reverse

}
