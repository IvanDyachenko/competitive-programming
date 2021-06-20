package com.codeforces.round632div2

/** B. Kind Anton
  * - https://codeforces.com/contest/1333/problem/B
  */
object B extends App {
  case class Case(as: List[Int], bs: List[Int])

  private def isPossible(c: Case): Boolean = {
    val Case(as, bs) = c

    val p = as.indexOf(1)
    val m = as.indexOf(-1)

    bs.zip(as).zipWithIndex.forall { case ((a, b), i) =>
      if (b == a) true
      else if (b > a) m > -1 && m < i
      else p > -1 && p < i
    }
  }

  val t = scala.io.StdIn.readInt()

  val cases = (0 until t)
    .foldLeft(List.empty[Case]) { (acc, _) =>
      scala.io.StdIn.readInt()
      val as = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList
      val bs = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

      Case(as, bs) :: acc
    }
    .reverse

  val answers = cases.map(isPossible)

  answers.foreach(if (_) println("YES") else println("NO"))
}
