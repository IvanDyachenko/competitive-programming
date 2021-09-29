package com.codeforces.contest.round744div3

/** D. Productive Meeting
  * https://codeforces.com/contest/1579/problem/D
  */
object D extends App {
  import scala.collection.mutable.PriorityQueue

  type Talk = (Int, Int)

  def productiveMeeting(persons: IndexedSeq[Int]): List[Talk] = {
    val pq = PriorityQueue(persons.zipWithIndex: _*)

    @annotation.tailrec
    def go(talks: List[Talk]): List[Talk] =
      if (pq.length > 1) {
        val (s1, p1) = pq.dequeue()
        val (s2, p2) = pq.dequeue()

        if (s1 <= 0 || s2 <= 0) talks
        else {
          pq.enqueue((s1 - 1, p1), (s2 - 1, p2))
          go((p1, p2) :: talks)
        }
      } else talks

    go(List.empty[Talk])
  }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n  = nextInt()
    val pn = nextInts(n)

    val ts = productiveMeeting(pn)

    out.println(ts.length)
    ts.foreach { case (i, j) => out.println(s"${i + 1} ${j + 1}") }
  }

  out.flush()

  final object InOut {
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
