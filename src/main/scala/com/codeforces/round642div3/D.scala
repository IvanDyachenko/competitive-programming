package com.codeforces.round642div3

/**
  * D. Constructing the Array
  * https://codeforces.com/contest/1353/problem/D
  */
object D extends App {
  import InOut._
  import scala.collection.mutable.TreeSet

  object SegOrdering extends Ordering[(Int, Int)] {
    implicit def compare(x: (Int, Int), y: (Int, Int)): Int = {
      val (l1, r1)     = x
      val (l2, r2)     = y
      val (len1, len2) = (r1 - l1 + 1, r2 - l2 + 1)

      if (len1 > len2) -1
      else if (len1 < len2) 1
      else if (l1 < l2) -1
      else if (l1 > l2) 1
      else 0
    }
  }

  val t = nextInt

  (0 until t).foreach { _ =>
    val n = nextInt

    var an   = Array.ofDim[Int](n)
    var segs = TreeSet[(Int, Int)]((0, n - 1))(SegOrdering)

    (1 to n).foreach { v =>
      val (l, r) = segs.head

      val i = (l + r) / 2

      segs -= ((l, r))
      if (i > l) segs += ((l, i - 1))
      if (i < r) segs += ((i + 1, r))

      an(i) = v
    }

    out.println(an.mkString(" "))
    out.flush()
  }

  final object InOut {
    val in                                                 = new java.io.BufferedReader(new java.io.InputStreamReader(System.in))
    val out                                                = new java.io.PrintWriter(System.out, false)
    private[this] var tokenizer: java.util.StringTokenizer = _
    def nextToken: String = {
      while (tokenizer == null || !tokenizer.hasMoreTokens)
        tokenizer = new java.util.StringTokenizer(in.readLine)
      tokenizer.nextToken
    }
    def nextInt           = Integer.parseInt(nextToken)
    def nextLong          = java.lang.Long.parseLong(nextToken)
    def nextBig           = BigInt(nextToken)
    def nextInts(n: Int)  = Array.fill(n)(nextInt)
    def nextLongs(n: Int) = Array.fill(n)(nextLong)
    def nextBigs(n: Int)  = Array.fill(n)(nextBig)
    def nextLine          = in.readLine
  }
}
