package com.codeforces.contest.round744div3

/** A. Casimir's String Solitaire
  * https://codeforces.com/contest/1579/problem/A
  */
object A extends App {

  def solitaire(s: String): Boolean = {
    val counts = Array.fill(3)(0)
    s.foreach(letter => counts(letter - 'A') += 1)
    counts(1) == counts(0) + counts(2)
  }

  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val s = readLine()

    solitaire(s) match {
      case true  => println("YES")
      case false => println("NO")
    }
  }
}
