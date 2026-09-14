package com.leetcode.problems.medium

/** 362. Design Hit Counter
  * https://leetcode.com/problems/design-hit-counter/
  */
class DesignHitCounter {
  import scala.collection.mutable.ArrayDeque

  class HitCounter() {
    private val delta = 300
    private val deque = ArrayDeque.empty[Int]

    def hit(timestamp: Int): Unit = {
      prune(timestamp)
      deque.append(timestamp)
    }

    def getHits(timestamp: Int): Int = {
      prune(timestamp)
      deque.length
    }

    private def prune(timestamp: Int): Unit =
      deque.removeHeadWhile(timestamp - _ >= delta)
  }

}
