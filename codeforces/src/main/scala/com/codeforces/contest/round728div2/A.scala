package com.codeforces.contest.round728div2

/** A. Pretty Permutations
  * https://codeforces.com/contest/1541/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n = readInt()
    val ans = {
      val t = Array.range(1, n + 1, 1).map {
        case i if n % 2 == 1 && i == n - 2 => n - 1
        case i if n % 2 == 1 && i == n - 1 => n
        case i if n % 2 == 1 && i == n     => n - 2
        case i if i % 2 == 0               => i - 1
        case i => i + 1
      }

      t
    }

    println(ans.mkString(" "))
  }
}
