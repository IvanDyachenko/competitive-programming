package com.codeforces.edu.suffix_array.step1

/** A. Suffix Array - 1
  * - https://codeforces.com/edu/course/2/lesson/2/1/practice/contest/269100/problem/A
  */
object A extends App {
  import scala.io.StdIn._

  def suffixes(str: String): Seq[Int] = {
    val s = str + "$"
    val n = s.length

    var ps = Array.ofDim[Int](n)
    var cs = Array.ofDim[Int](n)

    s.zipWithIndex.sortBy(_._1).zipWithIndex.foldLeft('$') {
      case (_, ((curr, p), 0))    =>
        ps(0) = p
        cs(p) = 0
        curr
      case (prev, ((curr, p), i)) =>
        ps(i) = p
        cs(p) = cs(ps(i - 1)) + (if (curr == prev) 0 else 1)
        curr
    }

    @annotation.tailrec
    def go(iter: Int): Seq[Int] =
      if (1 << iter > n) ps
      else {
        var sp = Array.ofDim[Int](n)
        var sc = Array.ofDim[Int](n)

        val xs = ps.map(p => p -> (cs(p), cs((p + (1 << iter)) % n))).sortBy(_._2)

        val z = xs.head._1
        sp(0) = z
        sc(z) = 0

        for {
          i      <- 1 until n
          (p, cp) = xs(i)
          (q, cq) = xs(i - 1)
        } {
          sp(i) = p
          sc(p) = sc(q) + (if (cp == cq) 0 else 1)
        }

        ps = sp
        cs = sc

        go(iter + 1)
      }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    // @annotation.tailrec                                                                                   //
    // def go(iter: Int): Seq[Int] =                                                                         //
    //   if (1 << iter > n) ps                                                                               //
    //   else {                                                                                              //
    //     var sp = Array.ofDim[Int](n)                                                                      //
    //     var sc = Array.ofDim[Int](n)                                                                      //
    //                                                                                                       //
    //     ps.map(p => (cs(p), cs((p + (1 << iter)) % n)) -> p).sortBy(_._1).zipWithIndex.foldLeft(0 -> 0) { //
    //       case (_, ((curr, p), 0)) =>                                                                     //
    //         sp(0) = p                                                                                     //
    //         sc(p) = 0                                                                                     //
    //         curr                                                                                          //
    //       case (prev, ((curr, p), i)) =>                                                                  //
    //         sp(i) = p                                                                                     //
    //         sc(p) = sc(sp(i - 1)) + (if (curr == prev) 0 else 1)                                          //
    //         curr                                                                                          //
    //     }                                                                                                 //
    //                                                                                                       //
    //     ps = sp                                                                                           //
    //     cs = sc                                                                                           //
    //                                                                                                       //
    //     go(iter + 1)                                                                                      //
    //   }                                                                                                   //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    go(0)
  }

  val ans = suffixes(readLine())

  println(ans.mkString(" "))
}
