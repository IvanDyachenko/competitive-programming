package com.leetcode.problems.medium

/** 438. Find All Anagrams in a String
  * https://leetcode.com/problems/find-all-anagrams-in-a-string/
  */
object FindAllAnagramsInAString {
  import scala.util.hashing.MurmurHash3

  def findAnagrams(an: String, pm: String): List[Int] = {
    val n = an.length
    val m = pm.length

    val pmHash = {
      val char2count = Array.fill(26)(0)
      pm.foreach(c => char2count(c - 97) += 1)
      MurmurHash3.orderedHash(char2count)
    }

    val char2count = Array.fill(26)(0)

    (0 until n)
      .foldLeft((List.empty[Int], 0)) {
        case (state @ (_, left), right) if right - left + 1 < m =>
          char2count(an(right) - 97) += 1
          state
        case ((ls, left), right)                                =>
          char2count(an(right) - 97) += 1
          val hash = MurmurHash3.orderedHash(char2count)
          char2count(an(left) - 97) -= 1
          if (hash == pmHash) (left :: ls, left + 1) else (ls, left + 1)
      }
      ._1
  }

}
