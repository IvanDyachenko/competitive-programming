package com.codeforces.contest.round744div3

import munit.FunSuite
import B._

class BSuite extends FunSuite {

  test("Codeforces | Round #744 | Div. 3 | B | 1 test case") {
    val an = Array(2, 5, 1, 4, 3)
    assertEquals(shiftingSort(an), List((0, 2, 2), (2, 4, 2), (3, 4, 1)))
  }

  test("Codeforces | Round #744 | Div. 3 | B | 2 test case") {
    val an = Array(2, 4, 1, 3)
    assertEquals(shiftingSort(an), List((0, 2, 2), (2, 3, 1)))
  }

  test("Codeforces | Round #744 | Div. 3 | B | 3 test case") {
    val an = Array(1, 2, 1)
    assertEquals(shiftingSort(an), List((1, 2, 1)))
  }

  test("Codeforces | Round #744 | Div. 3 | B | 4 test case") {
    val an = Array(2, 1)
    assertEquals(shiftingSort(an), List((0, 1, 1)))
  }

}
