package com.codeforces.edu.disjoint_sets_union.step1

/** B. Disjoint Sets Union 2
  * - https://codeforces.com/edu/course/2/lesson/7/1/practice/contest/289390/problem/B
  */
object B extends App {
  import scala.collection.mutable

  trait DisjointSet {
    def get(u: Int): Int
    def min(u: Int): Int
    def max(u: Int): Int
    def size(u: Int): Int
    def union(u: Int, v: Int): Unit
  }

  object DisjointSet {
    def apply(n: Int): DisjointSet = new DisjointSet {
      private[this] val ps    = (0 to n).toArray
      private[this] val mins  = (0 to n).toArray
      private[this] val maxs  = (0 to n).toArray
      private[this] val sizes = Array.fill(n + 1)(1)

      def get(u: Int): Int = {
        ps(u) = if (u == ps(u)) u else get(ps(u))
        ps(u)
      }

      def min(u: Int): Int = mins(get(u))

      def max(u: Int): Int = maxs(get(u))

      def size(u: Int): Int = sizes(get(u))

      def union(u: Int, v: Int): Unit = {
        val (pu, pv) = (get(u), get(v))

        if (pu != pv) {
          val (sizeu, sizev) = (size(pu), size(pv))

          if (sizeu > sizev) union(v, u)
          else {
            mins(pv) = mins(pv) min mins(pu)
            maxs(pv) = maxs(pv) max maxs(pu)
            sizes(pv) += sizes(pu)
            ps(pu) = pv
          }
        }
      }
    }
  }

  import InOut._

  val Array(n, m) = nextInts(2)
  val set         = DisjointSet(n)

  (0 until m).foreach { _ =>
    nextLine().split(" ") match {
      case Array("get", u) =>
        val ans1 = set.min(u.toInt - 1) + 1
        val ans2 = set.max(u.toInt - 1) + 1
        val ans3 = set.size(u.toInt - 1)
        out.println(s"$ans1 $ans2 $ans3")

      case Array("union", u, v) =>
        set.union(u.toInt - 1, v.toInt - 1)
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
