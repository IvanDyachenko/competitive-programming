package ru.yandex.contest.contest28738divB

/** D. Лавочки в атриуме
  * https://contest.yandex.ru/contest/28738/problems/D/
  */
object D extends App {
  def binarySearch(from: Int, to: Int, p: Int => Boolean): Int = {
    @annotation.tailrec
    def go(left: Int, right: Int): Int =
      if (left + 1 >= right) left
      else {
        val middle = (left + right) >> 1

        p(middle) match {
          case true  => go(middle, right)
          case false => go(left, middle)
        }
      }
    go(from, to)
  }

  import InOut._

  val l  = nextInt()
  val h  = (l + 1) / 2
  val k  = nextInt()
  val ak = nextInts(k)

  val i = binarySearch(0, k, i => ak(i) < h)
  val j = (i + 1) min (k - 1)

  (ak(i), ak(j)) match {
    case (ai, aj) if ai == aj    => out.println(ai)
    case (ai, aj) if ai == h - 1 => if (l % 2 == 1) out.println(ai) else out.println(s"$ai $aj")
    case (ai, aj)                => out.println(s"$ai $aj")
  }

  out.println()
  out.flush()

  object InOut {
    import java.util.Scanner

    val in  = new java.io.BufferedReader(new java.io.InputStreamReader(System.in))
    val out = new java.io.PrintWriter(System.out, false)

    def nextInt()        = Integer.parseInt(nextToken())
    def nextInts(n: Int) = Array.fill(n)(nextInt())

    def nextLong()        = java.lang.Long.parseLong(nextToken())
    def nextLongs(n: Int) = Array.fill(n)(nextLong())

    def nextBig()        = BigInt(nextToken())
    def nextBigs(n: Int) = Array.fill(n)(nextBig())

    def nextLine() = in.readLine()

    private[this] var tokenizer: java.util.StringTokenizer = _

    private[this] def nextToken(): String = {
      while (tokenizer == null || !tokenizer.hasMoreTokens())
        tokenizer = new java.util.StringTokenizer(in.readLine())
      tokenizer.nextToken()
    }
  }

}
