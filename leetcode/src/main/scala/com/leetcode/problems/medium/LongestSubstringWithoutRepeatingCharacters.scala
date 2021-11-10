package com.leetcode.problems.medium

import scala.collection.mutable.HashMap

/** 3. Longest Substring Without Repeating Characters
  * https://leetcode.com/problems/longest-substring-without-repeating-characters/
  */
object LongestSubstringWithoutRepeatingCharacters {

  def lengthOfLongestSubstring(s: String): Int = {
    val table = HashMap.empty[Char, Int]

    s.zipWithIndex
      .foldLeft((0, 0)) {
        case ((longest, left), (char, right)) if table.getOrElse(char, -1) < left =>
          table += char -> right
          (longest max (right - left + 1), left)
        case ((longest, left), (char, right))                                     =>
          val nextLeft = table(char)
          table += char -> right
          (longest, nextLeft + 1)
      }
      ._1
  }

}
