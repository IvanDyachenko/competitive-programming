package com.codeforces.contest.round743div2

import munit.FunSuite
import B._

class BSuite extends FunSuite {

  test("Codeforces | Round #743 | Div. 2 | B | 1 test case") {
    val an = Array(3, 1)
    val bn = Array(4, 2)
    assertEquals(swaps(an, bn), 0)
  }

  test("Codeforces | Round #743 | Div. 2 | B | 2 test case") {
    val an = Array(5, 3, 1)
    val bn = Array(2, 4, 6)
    assertEquals(swaps(an, bn), 2)
  }

  test("Codeforces | Round #743 | Div. 2 | B | 3 test case") {
    val an = Array(7, 5, 9, 1, 3)
    val bn = Array(2, 4, 6, 10, 8)
    assertEquals(swaps(an, bn), 3)
  }
}
