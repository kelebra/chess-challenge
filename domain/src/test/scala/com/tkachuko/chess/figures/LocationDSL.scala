package com.tkachuko.chess.figures

import com.tkachuko.chess.Location
import org.scalacheck.Gen
import org.scalatest.Matchers
import org.scalatest.prop.PropertyChecks

trait LocationDSL extends PropertyChecks with Matchers {

  val rowGenerator = for {row <- Gen.choose(1, 200)} yield row

  val columnGenerator = rowGenerator

  def distanceGenerator(distanceFilter: Int => Boolean) = for {
    distance <- Gen.choose(-100, 100)
    if distance > 0 && distanceFilter(distance)
  } yield distance

  def figureAttackTest(figure: ChessFigure, attackLocation: (Location, Int) => Location,
                       distanceFilter: (Int => Boolean) = Int => true, expected: Boolean): Unit =
    forAll(rowGenerator, columnGenerator, distanceGenerator(distanceFilter)) {
      (row: Int, column: Int, distance: Int) =>
        val figureLocation = Location(row, column)
        val attackCell = attackLocation(figureLocation, distance)
        figure.canAttack(from = figureLocation)(attackCell) shouldBe expected
    }

  implicit class LocationDSL(location: Location) {

    def cellsUp(distance: Int) = location.copy(row = location.row - distance)

    def cellsDown(distance: Int) = location.copy(row = location.row + distance)

    def cellsLeft(distance: Int) = location.copy(column = location.column - distance)

    def cellsRight(distance: Int) = location.copy(column = location.column + distance)

    def cellsLeftUpDiagonal(distance: Int) =
      location.copy(row = location.row - distance, column = location.column - distance)

    def cellsRightUpDiagonal(distance: Int) =
      location.copy(row = location.row - distance, column = location.column + distance)

    def cellsRightDownDiagonal(distance: Int) =
      location.copy(row = location.row + distance, column = location.column + distance)

    def cellsLeftDownDiagonal(distance: Int) =
      location.copy(row = location.row + distance, column = location.column - distance)
  }

}
