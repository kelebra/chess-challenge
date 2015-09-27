package com.tkachuko.chess.figures

import org.scalatest.WordSpec

class QueenSpec extends WordSpec with LocationDSL {

  "Queen" should {

    "attack figure on any distance on the right in its row" in {

      figureAttackTest(
        Queen,
        attackLocation = (figureLocation, distance) => figureLocation.cellsRight(distance),
        expected = true
      )
    }

    "attack figure on any distance on the left in its row" in {

      figureAttackTest(
        Queen,
        attackLocation = (figureLocation, distance) => figureLocation.cellsLeft(distance),
        expected = true
      )
    }

    "attack figure on any distance down in its column" in {

      figureAttackTest(
        Queen,
        attackLocation = (figureLocation, distance) => figureLocation.cellsDown(distance),
        expected = true
      )
    }

    "attack figure on any distance up in its column" in {

      figureAttackTest(
        Queen,
        attackLocation = (figureLocation, distance) => figureLocation.cellsUp(distance),
        expected = true
      )
    }

    "attack figure on any distance right in its row" in {

      figureAttackTest(
        Queen,
        attackLocation = (figureLocation, distance) => figureLocation.cellsRight(distance),
        expected = true
      )
    }

    "not attack like knight (right two cell move)" in {

      figureAttackTest(
        Queen,
        attackLocation = (figureLocation, _) => figureLocation.cellsRight(2).cellsDown(1),
        expected = false
      )
    }

    "not attack like knight (down two cell move)" in {

      figureAttackTest(
        Queen,
        attackLocation = (figureLocation, _) => figureLocation.cellsDown(2).cellsRight(1),
        expected = false
      )
    }
  }

}
