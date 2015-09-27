package com.tkachuko.chess.figures

import org.scalatest.WordSpec

class BishopSpec extends WordSpec with LocationDSL {

  "Bishop" should {

    "attack any figure on the diagonal (right up direction)" in {

      figureAttackTest(
        Bishop,
        attackLocation = (figureLocation, distance) => figureLocation.cellsRightUpDiagonal(distance),
        expected = true
      )
    }

    "attack any figure on the diagonal (left up direction)" in {

      figureAttackTest(
        Bishop,
        attackLocation = (figureLocation, distance) => figureLocation.cellsLeftUpDiagonal(distance),
        expected = true
      )
    }

    "attack any figure on the diagonal (right down direction)" in {

      figureAttackTest(
        Bishop,
        attackLocation = (figureLocation, distance) => figureLocation.cellsRightDownDiagonal(distance),
        expected = true
      )
    }

    "attack any figure on the diagonal (left down direction)" in {

      figureAttackTest(
        Bishop,
        attackLocation = (figureLocation, distance) => figureLocation.cellsLeftDownDiagonal(distance),
        expected = true
      )
    }

    "not attack figure in horizontal direction" in {
      figureAttackTest(
        Bishop,
        attackLocation = (figureLocation, distance) => figureLocation.cellsRight(distance),
        expected = false
      )
    }

    "not attack figure in vertical direction" in {
      figureAttackTest(
        Bishop,
        attackLocation = (figureLocation, distance) => figureLocation.cellsDown(distance),
        expected = false
      )
    }
  }

}
