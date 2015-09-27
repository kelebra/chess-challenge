package com.tkachuko.chess.figures

import org.scalatest.WordSpec

class RookSpec extends WordSpec with LocationDSL {

  "Rook" should {

    "attack any cell in its row" in {

      figureAttackTest(
        Rook,
        attackLocation = (figureLocation, distance) => figureLocation.cellsRight(distance),
        expected = true
      )
    }

    "attack any cell in its column" in {

      figureAttackTest(
        Rook,
        attackLocation = (figureLocation, distance) => figureLocation.cellsUp(distance),
        expected = true
      )
    }

    "not attack figures on the diagonal" in {

      figureAttackTest(
        Rook,
        attackLocation = (figureLocation, distance) => figureLocation.cellsLeftDownDiagonal(distance),
        expected = false
      )
    }
  }
}
