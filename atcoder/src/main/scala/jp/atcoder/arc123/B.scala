package jp.atcoder.arc123.B

/** B - Increasing Triples
  * https://atcoder.jp/contests/arc123/tasks/arc123_b
  */
object Main extends App {
  import scala.io.StdIn._

  val n  = readInt()
  val an = readLine().split(" ").map(_.toInt).sorted
  val bn = readLine().split(" ").map(_.toInt).sorted
  val cn = readLine().split(" ").map(_.toInt).sorted

  val ans = {
    @annotation.tailrec
    def go(i: Int, j: Int, k: Int, count: Int): Int =
      if (i == n || j == n || k == n) count
      else {
        val p = binarySearch(j, n, bn(_) > an(i))

        if (p == n) count
        else {
          val q = binarySearch(k, n, cn(_) > bn(p))

          if (q == n) count
          else go(i + 1, p, q, count + 1)
        }
      }

    go(0, -1, -1, 0)
  }

  println(ans)

  @annotation.tailrec
  def binarySearch(l: Int, r: Int, f: Int => Boolean): Int =
    if (l + 1 >= r) r
    else {
      val m = (l + r) / 2
      f(m) match {
        case true => binarySearch(l, m, f)
        case _    => binarySearch(m, r, f)
      }
    }
}
