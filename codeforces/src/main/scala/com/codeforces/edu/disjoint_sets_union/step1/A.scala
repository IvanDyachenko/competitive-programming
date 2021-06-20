package com.codeforces.edu.disjoint_sets_union.step1

/** A. Disjoint Sets Union
  * - https://codeforces.com/edu/course/2/lesson/7/1/practice/contest/289390/problem/A
  */
object A extends App {
  import scala.collection.mutable

  trait DisjointSet {
    def get(u: Int): Int
    def union(u: Int, v: Int): Unit
  }

  object DisjointSet {
    def apply(n: Int) = new DisjointSet {
      private[this] val ps = (0 until n).toArray
      private[this] val ls = ps.map(v => mutable.UnrolledBuffer(v))

      override def get(u: Int): Int = ps(u)

      override def union(u: Int, v: Int): Unit = {
        val (pu, pv) = (ps(u), ps(v))

        if (pu != pv) {
          val (lu, lv) = (ls(pu), ls(pv))

          if (lu.length > lv.length) union(v, u)
          else {
            lu.foreach(a => ps(a) = pv)
            lv.concat(lu)
          }
        }
      }
    }
  }

  import InOut._

  val Array(n, m) = nextInts(2)

  val set = DisjointSet(n)

  (0 until m).foreach { _ =>
    nextLine().split(" ") match {
      case Array("get", u, v)   =>
        val ans = if (set.get(u.toInt - 1) == set.get(v.toInt - 1)) "YES" else "NO"
        out.println(ans)
      case Array("union", u, v) => set.union(u.toInt - 1, v.toInt - 1)
    }
  }
  out.flush()

  final object InOut {
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

    def nextToken(): String = {
      while (tokenizer == null || !tokenizer.hasMoreTokens())
        tokenizer = new java.util.StringTokenizer(in.readLine())
      tokenizer.nextToken()
    }
  }
}
