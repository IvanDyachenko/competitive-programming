package ru.yandex.contest.contest8458

/** E. Анаграммы
  * https://contest.yandex.ru/contest/8458/problems/E/
  */
object E extends App {
  import InOut._

  val char2count = Array.fill(26)(0)

  nextLine().foreach { char => char2count(char - 97) += 1 }
  nextLine().foreach { char => char2count(char - 97) -= 1 }

  char2count.forall(_ == 0) match {
    case true  => out.println(1)
    case false => out.println(0)
  }

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
