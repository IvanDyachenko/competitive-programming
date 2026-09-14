package com.leetcode.problems.medium

import scala.collection.mutable.LinkedHashMap

/** 340. Longest Substring with At Most K Distinct Characters
  * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
  */
object LongestSubstringWithAtMostKDistinctCharacters {

  def lengthOfLongestSubstringKDistinct(s: String, k: Int): Int = {
    val table = LinkedHashMap.empty[Char, Int]

    s.zipWithIndex
      .foldLeft((0, 0, 0)) {
        case ((longest, left, right), (char, index)) if table.contains(char) || table.size < k =>
          table -= char
          table += char -> index
          (longest max (index - left + 1), left, index)
        case (state @ (longest, left, right), (char, index))                                   =>
          table.headOption.map { case (letter, lowest) =>
            table -= letter
            table += char -> index
            (longest, lowest + 1, index)
          }.getOrElse(state)

      }
      ._1
  }

}
