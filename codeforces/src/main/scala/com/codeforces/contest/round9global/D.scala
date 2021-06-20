package com.codeforces.round9global

/** D. Replace by MEX
  * - https://codeforces.com/contest/1375/problem/D
  */
object D extends App {
  import scala.io.StdIn._
  import scala.collection.immutable.TreeSet

  private def replace(n: Int, an: IndexedSeq[Int]): IndexedSeq[Int] = {
    def go(bn: IndexedSeq[Int], xk: List[Int] = List.empty): IndexedSeq[Int] =
      bn.zipWithIndex.collect { case (b, i) if b != i => i } match {
        case i +: is =>
          val mex = TreeSet((0 to n) diff bn: _*).min

          if (mex == n) go(bn.updated(i, n), (i + 1) :: xk)
          else go(bn.updated(mex, mex), (mex + 1) :: xk)

        case _ => xk.reverse.toIndexedSeq
      }

    go(an)
  }

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val xk = replace(n, an)

    println(xk.length)
    println(xk.mkString(" "))
  }
}
