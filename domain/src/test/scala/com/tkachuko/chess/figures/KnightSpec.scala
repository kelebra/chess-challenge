package com.tkachuko.chess.figures

import org.scalatest.WordSpec

class KnightSpec extends WordSpec with LocationDSL {

  "Knight" should {

    "attack any cell with composite move: 2 down and 1 right" in {

      figureAttackTest(
        Knight,
        attackLocation = (figureLocation, _) => figureLocation.cellsDown(2).cellsRight(1),
        expected = true
      )
    }

    "attack any cell with composite move: 2 down and 1 left" in {

      figureAttackTest(
        Knight,
        attackLocation = (figureLocation, _) => figureLocation.cellsDown(2).cellsLeft(1),
        expected = true
      )
    }

    "attack any cell with composite move: 2 up and 1 right" in {

      figureAttackTest(
        Knight,
        attackLocation = (figureLocation, _) => figureLocation.cellsUp(2).cellsRight(1),
        expected = true
      )
    }

    "attack any cell with composite move: 2 up and 1 left" in {

      figureAttackTest(
        Knight,
        attackLocation = (figureLocation, _) => figureLocation.cellsUp(2).cellsLeft(1),
        expected = true
      )
    }

    "attack any cell with composite move: 2 right and 1 up" in {

      figureAttackTest(
        Knight,
        attackLocation = (figureLocation, _) => figureLocation.cellsRight(2).cellsUp(1),
        expected = true
      )
    }

    "attack any cell with composite move: 2 right and 1 down" in {

      figureAttackTest(
        Knight,
        attackLocation = (figureLocation, _) => figureLocation.cellsRight(2).cellsDown(1),
        expected = true
      )
    }

    "attack any cell with composite move: 2 left and 1 up" in {

      figureAttackTest(
        Knight,
        attackLocation = (figureLocation, _) => figureLocation.cellsLeft(2).cellsUp(1),
        expected = true
      )
    }

    "attack any cell with composite move: 2 left and 1 down" in {

      figureAttackTest(
        Knight,
        attackLocation = (figureLocation, _) => figureLocation.cellsLeft(2).cellsDown(1),
        expected = true
      )
    }

    "not attack any figure in its row" in {
      figureAttackTest(
        Knight,
        attackLocation = (figureLocation, distance) => figureLocation.cellsRight(distance),
        expected = false
      )
    }

    "not attack any figure in its column" in {
      figureAttackTest(
        Knight,
        attackLocation = (figureLocation, distance) => figureLocation.cellsUp(distance),
        expected = false
      )
    }

    "not attack any figure on diagonal" in {
      figureAttackTest(
        Knight,
        attackLocation = (figureLocation, distance) => figureLocation.cellsRightDownDiagonal(distance),
        expected = false
      )
    }
  }
}
