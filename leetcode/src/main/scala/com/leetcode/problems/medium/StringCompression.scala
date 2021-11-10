package com.leetcode.problems.medium

/** 443. String Compression
  * https://leetcode.com/problems/string-compression/
  */
object StringCompression {

  def compress(chars: Array[Char]): Int =
    chars.headOption.map { head =>
      chars.tail
        .foldLeft(List(1 -> head)) {
          case ((count, previous) :: ls, current) if current == previous => (count + 1, current) :: ls
          case (ls, current)                                             => (1, current) :: ls
        }
        .reverse
        .foldLeft(0) {
          case (size, (1, char))     =>
            chars(size) = char
            size + 1
          case (size, (count, char)) =>
            chars(size) = char
            count.toString.foldLeft(size + 1) { (size, digit) =>
              chars(size) = digit
              size + 1
            }
        }
    }.getOrElse(0)

}
