package com.codeforces.round648div2

/** C. Rotation Matching
  * - https://codeforces.com/contest/1365/problem/C
  */
object C extends App {
  import scala.collection.mutable

  val n  = scala.io.StdIn.readInt()
  val an = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  val bn = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  val table = Array.fill(n)(0)

  (0 until n).foreach(i => table(an(i) - 1) += i)

  var offset = mutable.Map.empty[Int, Int]

  (0 until n).foreach { i =>
    val k = (n + (table(bn(i) - 1) - i) % n) % n
    offset(k) = offset.getOrElseUpdate(k, 0) + 1
  }

  val ans = offset.maxBy(_._2)._2

  println(ans)
}
