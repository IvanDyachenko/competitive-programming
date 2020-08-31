package com.codeforces.contest.edu.suffix_array

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import com.codeforces.edu.suffix_array.SuffixArray._

class SuffixArraySpec extends AnyFlatSpec with Matchers {
  "'ababba'" should "have correct suffixes 1" in {
    suffixes1("ababba") should equal("ababba".tails.toList.sorted)
  }

  "'ababba'" should "have correct suffixes 2" in {
    suffixes2("ababba") should equal("ababba".tails.toList.sorted)
  }
}
