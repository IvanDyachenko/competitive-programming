package com.codeforces.round9global

/** C. Element Extermination
  * - https://codeforces.com/contest/1375/problem/C
  */
object C extends App {
  import scala.io.StdIn._
  import scala.annotation.tailrec

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

//    @tailrec
//    def clean(pair: (Int, Int), pairs: List[(Int, Int)]): List[(Int, Int)] = pairs match {
//      case (a, b) :: ps if (a < pair._2) => clean((a, pair._2), ps)
//      case _                             => pair :: pairs
//    }

//    @tailrec
//    def collapse(from: Int = 0, pairs: List[(Int, Int)] = List.empty): Boolean =
//      if (from == -1) pairs.length == 1
//      else {
//        val a  = an(from)
//        val to = an.indexWhere(_ < a)
//        val pair = (from until (if (to == -1) n else to)).foldLeft((n, 0)) {
//          case ((x, y), j) => (x min an(j), y max an(j))
//        }
//
//        collapse(to, clean(pair, pairs))
//      }

    val ans = an.head < an.last

    if (ans) println("YES")
    else println("NO")
  }
}
