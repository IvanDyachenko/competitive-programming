package com.codeforces.round93edu

/** C. Good Subarrays https://codeforces.com/contest/1398/problem/C
  * - https://codeforces.com/blog/entry/81410?#comment-680498
  * -https://codeforces.com/blog/entry/81410?#comment-680824
  *
  * a_l + ... + a_r = r - l + 1
  *
  * \sum\limits_{i=l}^r{a_i} = r - l + 1 \sum\limits_{i=l}^r{a_i} - \sum\limits_{i=l}^r{1} = 0 \sum\limits_{i=l}^r{a_i -
  * 1} = 0
  *
  * Let b_i = a_i - 1 \sum\limits_{i=l}^r{b_i} = 0 prefix_sum(r) - prefix_sum(l - 1) = 0 prefix_sum(r) = prefix_sum(l -
  * 1)
  */
object C extends App {
  import scala.io.StdIn._
  import scala.collection.immutable.HashMap

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split("").map(_.toInt)

    val ans = an
      .map(_ - 1)
      .foldLeft((0L, 0L, HashMap(0L -> 1))) { // prefix_sum(0) = 0  -->  counts(0) = 1
        case ((answer, prefix, counts), a) =>
          val key = prefix + a
          val add = counts.getOrElse(key, 0) //

          (answer + add, key, counts + (key -> (add + 1)))
      }
      ._1

    println(ans)
  }
}
