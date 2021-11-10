package com.leetcode.problems.medium

import scala.util.hashing.MurmurHash3
import scala.collection.mutable.HashSet

/** 356. Line Reflection
  * https://leetcode.com/problems/line-reflection/
  */
object LineReflection {

  def isReflected(points: Array[Array[Int]]): Boolean = {
    for {
      left  <- points.minByOption(_(0))
      right <- points.maxByOption(_(0))
      total  = left(0) + right(0)
    } yield {
      val table = HashSet.empty[Int]
      points.foreach { table += MurmurHash3.orderedHash(_) }
      points.forall { case Array(x, y) =>
        table.contains(MurmurHash3.orderedHash(Array(total - x, y)))
      }
    }
  }.getOrElse(true)

}
