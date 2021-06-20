package com.codeforces.round657div2

/** A. Acacius and String
  * - https://codeforces.com/contest/1379/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  val target = "abacaba"

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val sn = readLine()

    def check(from: Int): Boolean = {
      val sm = sn.slice(from, from + 7)

      if (sm.corresponds(target) { case ('?', _) => true; case (x, y) => x == y }) {
        val kn = sn.patch(from, target, target.length)
        kn.indexOfSlice(target) == kn.lastIndexOfSlice(target)
      } else false
    }

    val ans = (0 until n).collectFirst { case i if check(i) => i }

    ans match {
      case None    => println("NO")
      case Some(i) =>
        val res = sn.patch(i, target, target.length).map { case '?' => 'd'; case c => c }
        println("YES")
        println(res)
    }
  }
}
