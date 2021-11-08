package ru.yandex.contest.contest29964

/** A. Камни и украшения
  * https://contest.yandex.ru/contest/29964/problems/A/
  */
object A extends App {
  import InOut._

  val j = nextLine()
  val s = nextLine()

  val rock2count = s.groupMapReduce(_ - 97)(_ => 1)(_ + _)
  val jewels     = j.distinct.foldLeft(0) { (result, jewel) =>
    result + rock2count.applyOrElse(jewel - 97, (_: Int) => 0)
  }

  out.println(jewels)
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
