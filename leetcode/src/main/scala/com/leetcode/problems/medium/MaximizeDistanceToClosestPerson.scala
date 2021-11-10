package com.leetcode.problems.medium

/** 849. Maximize Distance to Closest Person
  * https://leetcode.com/problems/maximize-distance-to-closest-person/
  */
object MaximizeDistanceToClosestPerson {

  def maxDistToClosest(seats: Array[Int]): Int = {
    val n = seats.length

    val prefixes = seats.zipWithIndex.scanLeft(-1) {
      case (previous, (0, _))       => previous
      case (previous, (_, current)) => current
    }

    val suffixes = seats.zipWithIndex.scanRight(n) {
      case ((0, _), previous)       => previous
      case ((_, current), previous) => current
    }

    seats.zipWithIndex
      .foldLeft(0) {
        case (maximum, (1, _))       => maximum
        case (maximum, (_, current)) =>
          val left  = if (prefixes(current) == -1) n else current - prefixes(current)
          val right = if (suffixes(current) == n) n else suffixes(current) - current

          maximum max (left min right)
      }
  }

}
