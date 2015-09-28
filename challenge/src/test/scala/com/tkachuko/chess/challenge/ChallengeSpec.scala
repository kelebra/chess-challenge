package com.tkachuko.chess.challenge

import com.tkachuko.chess.figures._
import org.scalatest.{Matchers, WordSpec}

class ChallengeSpec extends WordSpec with Matchers {

  "Challenge" should {

    "be solved with 4 layouts for 3x3 board and figures (K, K, R)" in {

      Challenge.allDrawPositions(King :: King :: Rook :: Nil, 3, 3).size shouldBe 4
    }
  }
}
