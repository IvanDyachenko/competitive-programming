package com.leetcode.problems.medium

import scala.util.hashing.MurmurHash3

/** 567. Permutation in String
  * https://leetcode.com/problems/permutation-in-string/
  */
object PermutationInString {

  def checkInclusion(s1: String, s2: String): Boolean = {
    val hash = {
      val char2count = Array.fill(26)(0)
      s1.foreach(c => char2count(c - 97) += 1)
      MurmurHash3.orderedHash(char2count)
    }

    val char2count = Array.fill(26)(0)

    s2.zipWithIndex
      .foldLeft((false, 0)) {
        case (state @ (_, left), (char, right)) if right - left + 1 < s1.length =>
          char2count(char - 97) += 1
          state
        case (state @ (true, _), _)                                             => state
        case ((result, left), (char, right))                                    =>
          char2count(char - 97) += 1
          val candidate = MurmurHash3.orderedHash(char2count)
          char2count(s2(left) - 97) -= 1
          (hash == candidate, left + 1)
      }
      ._1

  }

}
