package com.codeforces.contest.round114edu

import munit.FunSuite
import A._

class ASuite extends FunSuite {

  test("Codeforces | Round #114 | Educational | A | 1 test case") {
    assertEquals(brackets(1), List("()"))
  }

  test("Codeforces | Round #114 | Educational | A | 2 test case") {
    assertEquals(brackets(2), List("()()", "(())"))
  }

  test("Codeforces | Round #114 | Educational | A | 3 test case") {
    assertEquals(brackets(3), List("(())()", "(()())", "((()))"))
  }

}
