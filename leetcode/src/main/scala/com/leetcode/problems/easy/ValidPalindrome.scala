package com.leetcode.problems.easy

/** 125. Valid Palindrome
  * https://leetcode.com/problems/valid-palindrome/
  */
object ValidPalindrome {

  def isPalindrome(s: String): Boolean = {
    @annotation.tailrec
    def go(left: Int, right: Int): Boolean =
      if (left >= right) true
      else if (!s(left).isLetterOrDigit) go(left + 1, right)
      else if (!s(right).isLetterOrDigit) go(left, right - 1)
      else s(left).toLower == s(right).toLower && go(left + 1, right - 1)

    go(0, s.length - 1)
  }

}
