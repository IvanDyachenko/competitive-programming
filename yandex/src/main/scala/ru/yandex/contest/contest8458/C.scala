package ru.yandex.contest.contest8458

/** C. Удаление дубликатов
  * https://contest.yandex.ru/contest/8458/problems/C/
  */
object C extends App {
  import InOut._

  nextInt() match {
    case 0 =>
    case n =>
      val first = nextInt()

      { out.println(first); out.flush() }

      (1 until n).foldLeft(first) { (previous, _) =>
        val current = nextInt()
        if (previous != current) { out.println(current); out.flush() }
        current
      }
  }

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
