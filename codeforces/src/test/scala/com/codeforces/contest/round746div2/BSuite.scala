package com.codeforces.contest.round746div2

import munit.FunSuite
import B._

class BSuite extends FunSuite {

  test("Codeforces | Round #746 | Div. 2 | B | 1 test case") {
    assert(!hemoseShopping(Array(3, 2, 1), 3))
  }

  test("Codeforces | Round #746 | Div. 2 | B | 2 test case") {
    assert(hemoseShopping(Array(1, 2, 3, 4), 3))
  }

  test("Codeforces | Round #746 | Div. 2 | B | 3 test case") {
    assert(hemoseShopping(Array(5, 1, 2, 3, 4), 2))
  }

  test("Codeforces | Round #746 | Div. 2 | B | 4 test case") {
    assert(hemoseShopping(Array(1, 2, 3, 4, 4), 4))
  }

  test("Codeforces | Round #746 | Div. 2 | B | 5 test case") {
    assert(hemoseShopping(Array(4, 3, 2, 1, 0), 3))
  }

  test("Codeforces | Round #746 | Div. 2 | B | 6 test case") {
    assert(!hemoseShopping(Array(4, 3, 2, 1), 3))
  }

}
