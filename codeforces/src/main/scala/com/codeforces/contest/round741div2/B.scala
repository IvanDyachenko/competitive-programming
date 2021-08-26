package com.codeforces.contest.round741div2

/** B. Scenes From a Memory
  * https://codeforces.com/contest/1562/problem/B
  */
object B extends App {
  def remove(input: String): String = {
    lazy val singles  = input.collectFirst { case char @ ('1' | '4' | '6' | '8' | '9') => char.toString }
    lazy val pairs    = input.tail.collectFirst { case char @ ('2' | '5') => s"${input.head}$char" }
    lazy val doubles  = input.groupBy(identity).collectFirst { case (char, slice) if slice.length > 1 => s"$char$char" }
    lazy val specials = s"${input.head}7"

    singles getOrElse (pairs getOrElse (doubles getOrElse specials))
  }

  import scala.io.StdIn._

  val t = readInt()

  (0 until t).foreach { _ =>
    val k      = readInt()
    val number = readLine()

    val output = remove(number)

    println(output.length)
    println(output)
  }

}
