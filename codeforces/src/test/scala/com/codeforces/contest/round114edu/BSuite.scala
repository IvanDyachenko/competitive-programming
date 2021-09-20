package com.codeforces.contest.round114edu

import munit.FunSuite
import B._

class BSuite extends FunSuite {

  test("Codeforces | Round #114 | Educational | B | 1 test case") {
    assert(check(2, 2, 1, 0))
  }

  test("Codeforces | Round #114 | Educational | B | 2 test case") {
    assert(!check(1, 1, 1, 1))
  }

  test("Codeforces | Round #114 | Educational | B | 3 test case") {
    assert(check(1, 2, 3, 2))
  }

}
