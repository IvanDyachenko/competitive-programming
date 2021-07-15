package com.codeforces.contest.round111edu

/** C. Manhattan Subarrays
  * https://codeforces.com/contest/1550/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  type P = (Int, Int)

  def d(p: P, q: P): Int = math.abs(p._1 - q._1) + math.abs(p._2 - q._2)

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val ans = (0 until n).foldLeft(0) { case (count, i) =>
      (i until n).takeWhile {
        case j if i + 2 <= j =>
          val r = (j, an(j))

          (i until j).forall { k =>
            val p = (k, an(k))

            ((k + 1) until j).forall { t =>
              val q = (t, an(t))

              d(p, r) != d(p, q) + d(q, r)
            }
          }
        case _               => true
      }.length + count
    }

    println(ans)
  }
}
