package com.codeforces.contest.round114edu

import munit.FunSuite
import C._

class CSuite extends FunSuite {

  val heroes     = Array(3L, 6L, 2L, 3L)
  lazy val coins = slayTheDragon(heroes)

  test("Codeforces | Round #114 | Educational | C | 1 test case") {
    assertEquals(coins(3L, 12L), 1L)
  }

  test("Codeforces | Round #114 | Educational | C | 2 test case") {
    assertEquals(coins(7L, 9L), 2L)
  }

  test("Codeforces | Round #114 | Educational | C | 3 test case") {
    assertEquals(coins(4L, 14L), 4L)
  }

  test("Codeforces | Round #114 | Educational | C | 4 test case") {
    assertEquals(coins(1L, 10L), 0L)
  }

  test("Codeforces | Round #114 | Educational | C | 5 test case") {
    assertEquals(coins(8L, 7L), 2L)
  }

}
