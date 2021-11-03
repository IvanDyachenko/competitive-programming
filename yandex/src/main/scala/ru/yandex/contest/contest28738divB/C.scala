package ru.yandex.contest.contest28738divB

/** C. Изготовление палиндромов
  * https://contest.yandex.ru/contest/28738/problems/C/
  */
object C extends App {
  import InOut._

  val s = nextLine()
  val n = s.length

  val count = 0.until(n >> 1).foldLeft(0) {
    case (count, i) if s(i) == s(n - i - 1) => count
    case (count, _)                         => count + 1
  }

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
