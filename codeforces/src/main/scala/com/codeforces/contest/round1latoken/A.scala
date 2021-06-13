package com.codeforces.contest.round1latoken

/** A. Colour the Flag
  * - https://codeforces.com/contest/1534/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val Array(n, m) = readLine().split(" ").map(_.toInt)
    val anm         = Array.fill(n)(readLine().toCharArray)

    val ans =
      (0 until n).foldLeft((0, 0), (0, 0)) { case ((r, w), i) =>
        (0 until m).foldLeft(r, w) { case ((r, w), j) =>
          anm(i)(j) match {
            case 'R' => if ((i + j) % 2 == 0) ((1, r._2), w) else ((r._1, 1), w)
            case 'W' => if ((i + j) % 2 == 0) (r, (1, w._2)) else (r, (w._1, 1))
            case _   => (r, w)
          }
        }
      }

    ans match {
      case ((0 | 1, 0), (0, 0 | 1)) =>
        println("YES")
        (0 until n).foreach { i =>
          val l = (0 until m).map(j => if ((i + j) % 2 == 0) 'R' else 'W')
          println(l.mkString(""))
        }
      case ((0, 0 | 1), (0 | 1, 0)) =>
        println("YES")
        (0 until n).foreach { i =>
          val l = (0 until m).map(j => if ((i + j) % 2 == 0) 'W' else 'R')
          println(l.mkString(""))
        }
      case _                        => println("NO")
    }
  }
}
