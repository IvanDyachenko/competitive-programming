package com.leetcode.problems.medium

import scala.collection.mutable.Queue

/** 200. Number of Islands
  * https://leetcode.com/problems/number-of-islands/
  */
object NumberOfIslands {

  def numIslands(grid: Array[Array[Char]]): Int = {
    val n = grid.length
    val m = grid.headOption.map(_.length).getOrElse(0)

    val queue = Queue.empty[(Int, Int)]

    (0 until n).foldLeft(0) { (count, i) =>
      (0 until m).foldLeft(count) {
        case (count, j) if grid(i)(j) == '0' => count
        case (count, j)                      =>
          queue.enqueue(i -> j)

          while (queue.nonEmpty) {
            val (r, c) = queue.dequeue()
            grid(r)(c) = '0'

            if (r > 0 && grid(r - 1)(c) == '1') {
              grid(r - 1)(c) = '0'
              queue.enqueue((r - 1) -> c)
            }

            if (r + 1 < n && grid(r + 1)(c) == '1') {
              grid(r + 1)(c) = '0'
              queue.enqueue((r + 1) -> c)
            }

            if (c > 0 && grid(r)(c - 1) == '1') {
              grid(r)(c - 1) = '0'
              queue.enqueue(r -> (c - 1))
            }

            if (c + 1 < m && grid(r)(c + 1) == '1') {
              grid(r)(c + 1) = '0'
              queue.enqueue(r -> (c + 1))
            }
          }

          count + 1
      }
    }
  }

}
