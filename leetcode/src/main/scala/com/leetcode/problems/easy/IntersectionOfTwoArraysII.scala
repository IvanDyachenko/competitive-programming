package com.leetcode.problems.easy

/** Intersection of Two Arrays II
  * https://leetcode.com/problems/intersection-of-two-arrays-ii/
  */
object IntersectionOfTwoArraysII {
  import scala.collection.mutable.HashMap

  def intersect(xs: Array[Int], ys: Array[Int]): Array[Int] =
    if (xs.length > ys.length) intersect(ys, xs)
    else {
      val table = HashMap.empty[Int, Int]

      xs.foreach(table.updateWith(_)(_.orElse(Some(0)).map(_ + 1)))

      ys.foldLeft(List.empty[Int]) {
        case (ls, y) if table.getOrElse(y, 0) > 0 =>
          table.updateWith(y)(_.map(_ - 1))
          y :: ls
        case (ls, _)                              => ls
      }.toArray
    }

}
