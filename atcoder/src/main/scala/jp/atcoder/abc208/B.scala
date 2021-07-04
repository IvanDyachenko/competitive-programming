package jp.atcoder.abc208.B

/** B - Factorial Yen Coin
  * https://atcoder.jp/contests/abc208/tasks/abc208_b
  */
object Main extends App {
  import scala.io.StdIn._

  val n = readInt()

  val ans = {
    val Factorials = (2 to 10).toList.scanLeft(1) { case (f, i) => f * i }

    @annotation.tailrec
    def go(n: Int, count: Int, fs: List[Int]): Int =
      if (n <= 0) count
      else if (fs.head > n) go(n, count, fs.tail)
      else {
        val t = n / fs.head
        go(n - fs.head * t, count + t, fs.tail)
      }

    go(n, 0, Factorials.reverse)
  }

  println(ans)
}
