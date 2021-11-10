package com.leetcode.problems.medium

import munit.FunSuite
import FindAllAnagramsInAString._

class FindAllAnagramsInAStringSuite extends FunSuite {

  test("LeetCode | 438. Find All Anagrams in a String | 1 test case") {
    val an = "cbaebabacd"
    val bn = "abc"

    assertEquals(findAnagrams(an, bn), List(6, 0))
  }

}
