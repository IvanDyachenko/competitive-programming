package com.codeforces.round8global

/** A. C+=
  * - https://codeforces.com/contest/1368/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(a, b, n) = readLine().split(" ").map(_.toInt)

    lazy val fibs: Stream[(Int, Int)] = (0, 0) #:: (1, 1) #:: (fibs zip fibs.tail).map { case ((a, _), (b, i)) =>
      (a + b, i + 1)
    }

    val ans = fibs.zip(fibs.tail).collectFirst { case ((f0, i), (f1, _)) if f1 * a.max(b) + f0 * a.min(b) > n => i }.get

    println(ans)
  }
}
