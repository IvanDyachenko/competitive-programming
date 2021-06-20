package com.codeforces.round648div2

/** B. Trouble Sort
  * - https://codeforces.com/contest/1365/problem/B
  */
object B extends App {
  val t = scala.io.StdIn.readInt()

  (0 until t).foreach { _ =>
    val n  = scala.io.StdIn.readInt()
    val an = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val bn = scala.io.StdIn.readLine().split(" ").map(_.toInt)

    val bs  = bn.sum
    val ans = bn.sum > 0 && bn.sum < bn.length || (an, an.tail).zipped.forall(_ <= _)

    if (ans) println("Yes")
    else println("No")
  }
}
