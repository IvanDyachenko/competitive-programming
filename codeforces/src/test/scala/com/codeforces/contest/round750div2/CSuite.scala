package com.codeforces.contest.round750div2

import munit.FunSuite
import C._

class CSuite extends FunSuite {

  test("Codeforces | Round #750 | Div. 2 | C | 1 test case") {
    assertEquals(minimumNumberOfErasing("abcaacab"), Some(2))
  }

  test("Codeforces | Round #750 | Div. 2 | C | 2 test case") {
    assertEquals(minimumNumberOfErasing("xyzxyz"), None)
  }

  test("Codeforces | Round #750 | Div. 2 | C | 3 test case") {
    assertEquals(minimumNumberOfErasing("rprarlap"), Some(3))
  }

  test("Codeforces | Round #750 | Div. 2 | C | 4 test case") {
    assertEquals(minimumNumberOfErasing("khyyhhyhky"), Some(2))
  }

  test("Codeforces | Round #750 | Div. 2 | C | 5 test case") {
    assertEquals(minimumNumberOfErasing("abba"), Some(0))
  }

  test("Codeforces | Round #750 | Div. 2 | C | 6 test case") {
    assertEquals(minimumNumberOfErasing("abcba"), Some(0))
  }

  test("Codeforces | Round #750 | Div. 2 | C | 7 test case") {
    assertEquals(minimumNumberOfErasing("abbca"), Some(1))
  }

  test("Codeforces | Round #750 | Div. 2 | C | 8 test case") {
    assertEquals(minimumNumberOfErasing("y"), Some(0))
  }

  test("Codeforces | Round #750 | Div. 2 | C | 9 test case") {
    assertEquals(minimumNumberOfErasing("zorr"), None)
  }

  test("Codeforces | Round #750 | Div. 2 | C | 10 test case") {
    assertEquals(minimumNumberOfErasing("assssa"), Some(0))
  }

  test("Codeforces | Round #750 | Div. 2 | C | 11 test case") {
    assertEquals(minimumNumberOfErasing("eeekkk"), Some(3))
  }

  test("Codeforces | Round #750 | Div. 2 | C | 12 test case") {
    assertEquals(minimumNumberOfErasing("mzv"), None)
  }

  test("Codeforces | Round #750 | Div. 2 | C | 13 test case") {
    assertEquals(minimumNumberOfErasing("ofoonkfk"), None)
  }

  test("Codeforces | Round #750 | Div. 2 | C | 14 test case") {
    assertEquals(minimumNumberOfErasing("iwiws"), None)
  }

  test("Codeforces | Round #750 | Div. 2 | C | 15 test case") {
    assertEquals(minimumNumberOfErasing("x"), Some(0))
  }

  test("Codeforces | Round #750 | Div. 2 | C | 16 test case") {
    assertEquals(minimumNumberOfErasing("wwor"), None)
  }

  test("Codeforces | Round #750 | Div. 2 | C | 17 test case") {
    assertEquals(minimumNumberOfErasing("ebebbbebbb"), Some(3))
  }

  test("Codeforces | Round #750 | Div. 2 | C | 18 test case") {
    assertEquals(minimumNumberOfErasing("exsesoo"), None)
  }

  test("Codeforces | Round #750 | Div. 2 | C | 19 test case") {
    assertEquals(minimumNumberOfErasing("yz"), Some(1))
  }

  test("Codeforces | Round #750 | Div. 2 | C | 20 test case") {
    assertEquals(minimumNumberOfErasing("avavvvv"), Some(2))
  }

}
