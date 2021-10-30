package jp.atcoder.abc255.A

/** A - Distinct Strings
  * https://atcoder.jp/contests/abc225/tasks/abc225_a
  */
object Main extends App {

  implicit final class StringOps(private val input: String) extends AnyVal {

    def distinctStrings: Int = input.distinct.length match {
      case 1 => 1
      case 2 => 3
      case _ => 6
    }

  }

  import InOut._

  val s     = nextLine()
  val count = s.distinctStrings

  out.println(count)
  out.flush()

  object InOut {
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
