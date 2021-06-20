package com.codeforces.round90edu

/** C. Pluses and Minuses
  * - https://codeforces.com/contest/1373/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val s = readLine()

    val res = s.zipWithIndex
      .foldLeft((s.length.toLong, 0)) { case ((res, airbag), (c, i)) =>
        c match {
          case '+' => (res, airbag + 1)
          case '-' =>
            if (airbag > 0) (res, airbag - 1)
            else (res + i + 1, airbag)
        }
      }
      ._1

    println(res)
  }
}
