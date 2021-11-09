package com.leetcode.problems.medium

import scala.util.hashing.MurmurHash3
import scala.collection.mutable.HashMap

/** 49. Group Anagrams
  * https://leetcode.com/problems/group-anagrams/
  */
object GroupAnagrams {

  def groupAnagrams(xs: Array[String]): List[List[String]] = {
    val table = HashMap.empty[Int, List[String]]

    xs.foreach { x =>
      val counts = Array.fill(26)(0)
      x.foreach { c => counts(c - 97) += 1 }
      val hash   = MurmurHash3.orderedHash(counts)
      table.updateWith(hash)(_.orElse(Some(Nil)).map(x :: _))
    }

    table.values.toList
  }

}
