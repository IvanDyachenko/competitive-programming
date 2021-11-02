package ru.yandex.contest.contest8458

/** B. Последовательно идущие единицы
  * https://contest.yandex.ru/contest/8458/problems/B/
  */
object B extends App {
  import InOut._

  val n  = nextInt()
  val bn = nextInts(n)

  val count = bn
    .foldLeft((0, 0)) {
      case ((maximum, current), 1) => (maximum max (current + 1), current + 1)
      case ((maximum, _), _)       => (maximum, 0)
    }
    ._1

  out.println(count)
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
