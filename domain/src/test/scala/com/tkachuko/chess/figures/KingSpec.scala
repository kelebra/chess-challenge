package com.tkachuko.chess.figures

import org.scalatest.WordSpec

class KingSpec extends WordSpec with LocationDSL {

  "King" should {

    "attack figure one cell higher" in {

      figureAttackTest(
        King,
        attackLocation = (figureLocation, _) => figureLocation.cellsUp(1),
        expected = true
      )
    }

    "attack figure one cell down" in {

      figureAttackTest(
        King,
        attackLocation = (figureLocation, _) => figureLocation.cellsDown(1),
        expected = true
      )
    }

    "attack figure on the right" in {

      figureAttackTest(
        King,
        attackLocation = (figureLocation, _) => figureLocation.cellsRight(1),
        expected = true
      )
    }

    "attack figure on the left" in {

      figureAttackTest(
        King,
        attackLocation = (figureLocation, _) => figureLocation.cellsLeft(1),
        expected = true
      )
    }

    "attack figure on the diagonal in one cell range" in {
      figureAttackTest(
        King,
        attackLocation = (figureLocation, _) => figureLocation.cellsRightUpDiagonal(1),
        expected = true
      )
    }

    "not attack figure with distance more than one on the left" in {

      figureAttackTest(
        King,
        attackLocation = (figureLocation, distance) => figureLocation.cellsLeft(distance),
        distanceFilter = _ > 1,
        expected = false
      )
    }

    "not attack figure on the diagonal further than one cell" in {
      figureAttackTest(
        King,
        attackLocation = (figureLocation, distance) => figureLocation.cellsRightDownDiagonal(distance),
        distanceFilter = _ > 1,
        expected = false
      )
    }

    "not attack figure with distance more than one down" in {
      figureAttackTest(
        King,
        attackLocation = (figureLocation, distance) => figureLocation.cellsDown(distance),
        distanceFilter = _ > 1,
        expected = false
      )
    }
  }

}


