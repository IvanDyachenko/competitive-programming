package com.codeforces.ladder.from0to1300

/** B. Polo the Penguin and Matrix
  * - https://codeforces.com/problemset/problem/289/B
  */
object BPoloThePenguinAndMatrix extends App {
  import scala.io.StdIn._

  val Array(n, m, d) = readLine().split(" ").map(_.toInt)
  val anm = {
    val anm = Array.fill(n * m)(0 -> 0)

    (0 until n).foreach { i =>
      readLine().split(" ").map(_.toInt).zipWithIndex.map { case (a, j) => anm(i * m + j) = (a / d, a % d) }
    }

    anm
  }

  val ans = {
    val remainder = anm(0)._2
    val check     = anm.forall { case (k, r) => r == remainder }

    if (check) {
      val kmedian = anm.sortBy(_._1)(Ordering[Int].reverse)(n * m / 2)._1
      val count   = anm.foldLeft(0) { case (sum, (k, _)) => sum + Math.abs(k - kmedian) }
      Some(count)
    } else None
  }

  ans match {
    case Some(value) => println(value)
    case _           => println(-1)
  }
}
