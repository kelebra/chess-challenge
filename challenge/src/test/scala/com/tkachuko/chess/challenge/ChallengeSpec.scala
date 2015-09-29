package com.tkachuko.chess.challenge

import com.tkachuko.chess.figures._
import org.scalatest.{Matchers, WordSpec}
import Challenge._

class ChallengeSpec extends WordSpec with Matchers {

  "Challenge" should {

    "be solved with 4 layouts for 3x3 board and figures (2 Kings, 1 Rook)" in {

      allDrawPositions(King :: King :: Rook :: Nil, 3, 3).size shouldBe 4
    }

    "be solved with 8 layouts for 4x4 board and figures (2 Rooks, 4 Knights)" in {

      allDrawPositions(Rook :: Rook :: Knight :: Knight :: Knight :: Knight :: Nil, 4, 4).size shouldBe 8
    }

    "be solved with 3063828 layouts for 7x7 board and figures (2 Kings, 2 Queens, 2 Bishops, 1 Knight)" in {
      allDrawPositions(King :: King :: Queen :: Queen :: Bishop :: Bishop :: Knight :: Nil, 7, 7).size shouldBe 3063828
    }
  }
}
