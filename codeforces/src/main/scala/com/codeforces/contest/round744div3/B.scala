package com.codeforces.contest.round744div3

/** B. Shifting Sort
  * https://codeforces.com/contest/1579/problem/B
  */
object B extends App {

  type Shift = (Int, Int, Int)

  def shiftingSort(an: IndexedSeq[Int]): List[Shift] = {
    val bn = an.zipWithIndex.sorted

    bn.indices
      .foldLeft(List.empty[Shift]) { (shifts, i) =>
        val j = shifts.foldRight(bn(i)._2) {
          case ((l, r, d), j) if l <= j && j <= r =>
            val size = r - l + 1
            l + (j - l - d + size) % size
          case (_, j)                             => j
        }

        if (i == j) shifts else (i, j, j - i) :: shifts
      }
      .reverse
  }

  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val shifts = shiftingSort(an)

    println(shifts.length)
    println(shifts.map { case (l, r, d) => s"${l + 1} ${r + 1} $d" }.mkString("\n"))
  }
}
