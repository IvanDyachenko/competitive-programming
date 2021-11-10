package com.leetcode.problems.medium

import munit.FunSuite
import MaximizeDistanceToClosestPerson._

class MaximizeDistanceToClosestPersonSuite extends FunSuite {

  test("LeetCode | 849. Maximize Distance to Closest Person | 1 test case") {
    val seats = Array(1, 0, 0, 0, 1, 0, 1)
    assertEquals(maxDistToClosest(seats), 2)
  }

  test("LeetCode | 849. Maximize Distance to Closest Person | 2 test case") {
    val seats = Array(0, 1)
    assertEquals(maxDistToClosest(seats), 1)
  }

}
