package com.codeforces.contest.round746div2

import munit.FunSuite
import A._

class ASuite extends FunSuite {

  test("Codeforces | Round #746 | Div. 2 | A | 1 test case") {
    assertEquals(gamerHemose(Array(3, 7), 4), 1)
  }

  test("Codeforces | Round #746 | Div. 2 | A | 2 test case") {
    assertEquals(gamerHemose(Array(4, 2), 6), 2)
  }

  test("Codeforces | Round #746 | Div. 2 | A | 3 test case") {
    assertEquals(gamerHemose(Array(2, 1, 7), 11), 3)
  }

}
