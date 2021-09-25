package jp.atcoder.arc127.A

/** A - Leading 1s
  * https://atcoder.jp/contests/arc127/tasks/arc127_a
  */
object Main extends App {

  def leading1s(n: Long): Long = {

    @annotation.tailrec
    def go(base: Long, multiplier: Long, count: Long = 0L): Long =
      multiplier match {
        case 1 => go(base, multiplier * 10, count + 1)
        case _ =>
          (
            base * multiplier,
            (base * 10 + 1) * (multiplier / 10),
            (base * 10 + 2) * (multiplier / 10),
            (base + 1) * multiplier
          ) match {
            case (l, _, _, _) if n < l => count
            case (l, q, _, _) if n < q => count + n - l + 1
            case (l, q, p, _) if n < p => count + q - l
            case (l, q, p, r) if n < r => count + q - l + n - p + 1
            case (l, q, p, r)          => go(base, multiplier * 10, count + q - l + r - p)
          }
      }

    @annotation.tailrec
    def inner(base: Long, iter: Int, count: Long = 0L): Long =
      if (base > n) count
      else inner(base * 10L + 1L, iter + 1, count + go(base, 1L) * iter)

    inner(1L, 1)
  }

  import scala.io.StdIn._

  val n = readLong()

  println(leading1s(n))
}
