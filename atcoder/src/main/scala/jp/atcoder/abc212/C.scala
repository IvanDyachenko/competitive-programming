package jp.atcoder.abc212.C

/** C - Min Difference
  * https://atcoder.jp/contests/abc212/tasks/abc212_c
  */
object Main extends App {
  import scala.io.StdIn._

  val Array(n, m) = readLine().split(" ").map(_.toInt)
  val an          = readLine().split(" ").map(_.toInt).sorted
  val bm          = readLine().split(" ").map(_.toInt).sorted

  @annotation.tailrec
  def go(i: Int, j: Int, diff: Int): Int =
    if (i == n || j == m) diff
    else if (an(i) < bm(j)) go(i + 1, j, diff min (bm(j) - an(i)))
    else go(i, j + 1, diff min (an(i) - bm(j)))

  val ans = go(0, 0, Int.MaxValue)

  println(ans)
}
