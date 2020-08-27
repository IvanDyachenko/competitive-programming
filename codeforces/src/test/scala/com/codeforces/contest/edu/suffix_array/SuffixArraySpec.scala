package com.codeforces.contest.edu.suffix_array

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import com.codeforces.edu.suffix_array.SuffixArray.suffixes

class SuffixArraySpec extends AnyFlatSpec with Matchers {
  "'ababba'" should "have correct suffixes" in {
    suffixes("ababba") should equal("ababba".tails.toList.sorted)
  }
}
