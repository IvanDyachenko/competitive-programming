package com.codeforces.contest.round744div3

import munit.FunSuite
import D._

class DSuite extends FunSuite {

  test("Codeforces | Round #744 | Div. 3 | D | 1 test case") {
    val persons = Array(2, 3)
    assertEquals(productiveMeeting(persons), List((1, 0), (1, 0)))
  }

  test("Codeforces | Round #744 | Div. 3 | D | 2 test case") {
    val persons = Array(1, 2, 3)
    assertEquals(productiveMeeting(persons), List((2, 0), (2, 1), (2, 1)))
  }

  test("Codeforces | Round #744 | Div. 3 | D | 3 test case") {
    val persons = Array(1, 2, 3, 4)
    assertEquals(productiveMeeting(persons), List((1, 0), (3, 2), (3, 1), (3, 2), (3, 2)))
  }

  test("Codeforces | Round #744 | Div. 3 | D | 4 test case") {
    val persons = Array(0, 0, 2)
    assertEquals(productiveMeeting(persons), List.empty)
  }

  test("Codeforces | Round #744 | Div. 3 | D | 5 test case") {
    val persons = Array(0, 1, 0, 0, 6)
    assertEquals(productiveMeeting(persons), List((4, 1)))
  }

}
