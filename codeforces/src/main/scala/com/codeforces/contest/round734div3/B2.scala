package com.codeforces.contest.round734div3

/** B2. Wonderful Coloring - 2
  * https://codeforces.com/contest/1551/problem/B2
  */
object B2 extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val an          = readLine().split(" ").map(_.toInt)

    val cn = Array.fill(n)(0)

    val im = {
      val ai2is = Array.fill(n + 1)(List.empty[Int])
      (0 until n).foreach { i => ai2is(an(i)) ::= i }
      ai2is.flatMap(_.take(k))
    }

    ((im.length % k) until im.length).foreach { j =>
      val (i, ci) = (im(j), (j % k) + 1)
      cn(i) = ci
    }

    println(cn.mkString(" "))
  }
}
