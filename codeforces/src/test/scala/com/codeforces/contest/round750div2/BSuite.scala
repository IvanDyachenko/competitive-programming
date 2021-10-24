package com.codeforces.contest.round750div2

import munit.FunSuite
import B._

class BSuite extends FunSuite {

  test("Codeforces | Round #750 | Div. 2 | B | 1 test case") {
    assertEquals(numberOfNearlyFull(Array(1, 2, 3, 4, 5)), 1L)
  }

  test("Codeforces | Round #750 | Div. 2 | B | 2 test case") {
    assertEquals(numberOfNearlyFull(Array(1000, 1000)), 0L)
  }

  test("Codeforces | Round #750 | Div. 2 | B | 3 test case") {
    assertEquals(numberOfNearlyFull(Array(1, 0)), 2L)
  }

  test("Codeforces | Round #750 | Div. 2 | B | 4 test case") {
    assertEquals(numberOfNearlyFull(Array(3, 0, 2, 1, 1)), 4L)
  }

  test("Codeforces | Round #750 | Div. 2 | B | 5 test case") {
    assertEquals(numberOfNearlyFull(Array(2, 1, 0, 3, 0)), 4L)
  }

}
