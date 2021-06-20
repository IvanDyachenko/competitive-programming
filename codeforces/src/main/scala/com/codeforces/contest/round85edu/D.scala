package com.codeforces.round85edu

/** D. Minimum Euler Cycle
  * - https://codeforces.com/contest/1334/problem/D
  */
object D extends App {
  import scala.io.StdIn._
  import scala.annotation.tailrec

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, l, r) = readLine().split(" ").map(_.toLong)

    def collect: Unit = {
      @tailrec
      def go(i: Int = 1, p: Long = 0L): Unit =
        (p, p + 2 * (n - i)) match {
          case (p, q) if i > n || p >= r => println()
          case _ if i == n               => println(1)
          case (_, q) if q < l           => go(i + 1, q)
          case (p, q)                    =>
            lazy val stream: Stream[Int] = i #:: (i + 1) #:: stream.zip(stream.tail).map {
              case (j, _) if j == i => i
              case (j, _)           => j + 1
            }

            stream
              .drop(0 max (l - p - 1).toInt)
              .take((r.min(q) - p.max(l - 1)).toInt)
              .foreach(j => print(s"$j "))

            go(i + 1, q)
        }

      go()
    }

    collect
  }
}
