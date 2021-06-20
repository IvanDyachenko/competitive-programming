package com.codeforces.round665div2

/** C. Mere Array
  * - https://codeforces.com/contest/1401/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)
    val a  = an.min

    // format: off
    val ans = (an zip an.sorted).forall {
      case (x, y) if x == y     => true
      case (x, y) if x % a == 0 => true
      case _                    => false
    }
    // format: on

    if (ans) println("YES") else println("NO")
  }
}
