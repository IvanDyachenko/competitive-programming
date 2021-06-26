package jp.atcoder.abc207.C

/** C - Many Segments
  * https://atcoder.jp/contests/abc207/tasks/abc207_c
  */
object Main extends App {
  import scala.io.StdIn._

  val n  = readInt()
  val an = Array.fill(n) {
    val Array(t, l, r) = readLine().split(" ").map(_.toDouble)
    t match {
      case 1 => (l, r)
      case 2 => (l, r - 0.1)
      case 3 => (l + 0.1, r)
      case 4 => (l + 0.1, r - 0.1)
    }
  }

  val ans = an.indices.foldLeft(0) { case (count, i) =>
    val (li, ri) = an(i)
    count + ((i + 1) until n).count { j =>
      val (lj, rj) = an(j)
      (li max lj) <= (ri min rj)
    }
  }

  println(ans)
}
