package com.leetcode.problems.medium

/** 159. Longest Substring with At Most Two Distinct Characters
  * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
  */
object LongestSubstringWithAtMostTwoDistinctCharacters {

  def lengthOfLongestSubstringTwoDistinct(s: String): Int = {
    val index = s.indexWhere(_ != s.head)

    if (index == -1) s.length()
    else
      s.zipWithIndex
        .drop(index + 1)
        .foldLeft((index + 1, index + 1, 0, index)) {
          case ((longest, current, first, second), (char, index)) if char == s(first) =>
            (longest max (current + 1), current + 1, second, index)
          case ((longest, current, first, second), (char, _)) if char == s(second)    =>
            (longest max (current + 1), current + 1, first, second)
          case ((longest, _, _, second), (_, index))                                  =>
            (longest, index - second + 1, second, index)
        }
        ._1
  }

}
