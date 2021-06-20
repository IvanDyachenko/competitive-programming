package com.codeforces.contest.round669div2

/** B. Big Vova
  * - https://codeforces.com/contest/1407/problem/B
  */
object B extends App {
  import scala.io.StdIn._

  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    // This solution is based on the following idea: for each $i > 1$
    // either $c_i = c_{i -1}$ or $2 \cdot c_i \leq c_{i - 1}$. That
    // means any possible sequence $c$ contains $\mathcal{O}(\log A)$
    // different values.
    //
    // So we do $\mathcal{O}(\log A)$ iterations, on each we find the
    // value $x$ among the elements left in $a$ that maximize
    // $\mathcal{O}(c_k, x)$ (where $k$ is the amount of elements
    // already transfered to $b$, and $c_k = gcd(b_1, ..., b_k)$) and
    // transfer all the elements left in $a$ of the value equal to $x$
    // to the end of $b$. Each iteration is done in $\mathcal{O}(n \log A)$
    // so the total time complexity is $\mathcal{O}(n \log^2 A).
    @annotation.tailrec
    def go(an: Seq[Int], bn: List[Int], c: Int): Seq[Int] = an match {
      case Seq() => bn
      case _     =>
        val (ak, bk, d) = an.foldLeft((List.empty[Int], List.empty[Int], 0)) { case ((ak, bk, d), a) =>
          val g = gcd(c, a)

          if (g > d) (bk ::: ak, a :: Nil, g)
          else if (g == d) (ak, a :: bk, d)
          else (a :: ak, bk, d)
        }

        go(ak, bn ::: bk, d)
    }

    val bn = go(an, List.empty[Int], 0)

    println(bn.mkString(" "))

  ////////////////////////////////////////////////////////////////
  // $\mathcal{O}(n \cdot A \cdot \log(A))$, where $A = an.max$ //
  //                                                            //
  // val bn = Array.ofDim[Int](n)                               //
  // val counts = Array.fill(an.max + 1)(0)                     //
  // an.foreach(a => counts(a) += 1)                            //
  //                                                            //
  // @annotation.tailrec                                        //
  // def go(i: Int, c: Int): IndexedSeq[Int] =                  //
  //   if (i == n) bn                                           //
  //   else {                                                   //
  //     val (b, d) = counts.zipWithIndex.foldLeft(0 -> 0) {    //
  //       case (state, (0, a)) => state                        //
  //       case (state @ (_, d), (_, a)) =>                     //
  //         val g = gcd(c, a)                                  //
  //                                                            //
  //         if (g >= d) a -> g else state                      //
  //     }                                                      //
  //                                                            //
  //     bn(i) = b                                              //
  //     counts(b) -= 1                                         //
  //                                                            //
  //     go(i + 1, d)                                           //
  //   }                                                        //
  //                                                            //
  // go(0, an.max)                                              //
  ////////////////////////////////////////////////////////////////
  }
}
