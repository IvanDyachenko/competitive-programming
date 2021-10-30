package jp.atcoder.abc255.B

/** B - Star or Not
  * https://atcoder.jp/contests/abc225/tasks/abc225_b
  */
object Main extends App {
  import scala.collection.mutable

  def starOrNot(edges: Seq[(Int, Int)]): Boolean = {
    val map = mutable.Map.empty[Int, List[Int]]

    edges.foreach { case (u, v) =>
      val us = map.getOrElseUpdate(u, List.empty[Int])
      val vs = map.getOrElseUpdate(v, List.empty[Int])
      map.update(u, v :: us)
      map.update(v, u :: vs)
    }

    map.exists { case (_, connections) => connections.length == edges.length }
  }

  import InOut._

  val n     = nextInt()
  val edges = Array.fill(n - 1) {
    val u = nextInt()
    val v = nextInt()
    (u, v)
  }

  starOrNot(edges) match {
    case true  => out.println("Yes")
    case false => out.println("No")
  }

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
