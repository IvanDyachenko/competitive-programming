package com.codeforces.round664div2

/** C. Boboniu and Bit Operations
  * - https://codeforces.com/contest/1395/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val Array(n, m) = readLine().split(" ").map(_.toInt)
  val an          = readLine().split(" ").map(_.toInt)
  val bm          = readLine().split(" ").map(_.toInt)

  val ans = an
    .foldLeft(1 +: Array.fill(511)(0)) { (xs, a) =>
      xs.zipWithIndex.foldLeft(Array.fill(512)(0)) {
        case (ys, (0, _)) => ys
        case (ys, (1, i)) =>
          bm.foreach(b => ys(i | a & b) = 1) // (i | a & b) >= i
          ys
      }
    }
    .indexWhere(_ == 1)

  println(ans)
}
