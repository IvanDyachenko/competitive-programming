package com.leetcode.problems.medium

/** 986. Interval List Intersections
  * https://leetcode.com/problems/interval-list-intersections/
  */
object IntervalListIntersections {
  type Interval = Array[Int]

  def intervalIntersection(xn: Array[Interval], ym: Array[Interval]): Array[Interval] = {
    val n = xn.length
    val m = ym.length

    def go(i: Int, j: Int, intersections: List[Interval] = List.empty[Interval]): List[Interval] =
      if (i == n || j == m) intersections.reverse
      else {
        val Array(xl, xr) = xn(i)
        val Array(yl, yr) = ym(j)

        val (l, r) = (xl max yl, xr min yr)

        go(
          if (xr < yr) i + 1 else i,
          if (xr < yr) j else j + 1,
          if (l <= r) Array(l, r) :: intersections else intersections
        )
      }

    go(0, 0).toArray
  }

}
