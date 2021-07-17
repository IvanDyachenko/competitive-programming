package jp.atcoder.abc210.C

/** C - Colorful Candies
  * https://atcoder.jp/contests/abc210/tasks/abc210_c
  */
object Main extends App {
  import scala.io.StdIn._
  import scala.collection.mutable

  val Array(n, k) = readLine().split(" ").map(_.toInt)
  val cn          = readLine().split(" ").map(_.toInt)

  val ans = {
    val init = (0 until k).foldLeft(Map.empty[Int, Int]) { case (m, i) =>
      m.updatedWith(cn(i)) {
        case Some(c) => Some(c + 1)
        case _       => Some(1)
      }
    }

    (k until n)
      .foldLeft((init.size, init)) { case ((count, m), i) =>
        val w = m
          .updatedWith(cn(i - k)) {
            case Some(c) if c > 1 => Some(c - 1)
            case _                => None
          }
          .updatedWith(cn(i)) {
            case Some(c) => Some(c + 1)
            case _       => Some(1)
          }
        (count max w.size, w)
      }
      ._1
  }

  println(ans)
}
