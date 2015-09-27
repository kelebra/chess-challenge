package com.tkachuko.chess

import scala.math._

final case class Location(row: Int, column: Int) {

  def sharesRowWith(other: Location) = row == other.row

  def sharesColumnWith(other: Location) = column == other.column

  def sharesDiagonalWith(other: Location) = abs(row - other.row) == abs(column - other.column)

  def sharesDiagonalWith(other: Location, distance: Int) =
    abs(row - other.row) == distance && abs(column - other.column) == distance

  def sharesAdjacentRowWith(other: Location) = abs(row - other.row) == 1

  def sharesAdjacentColumnWith(other: Location) = abs(column - other.column) == 1

  def hasDistanceInRows(other: Location, distance: Int) = abs(row - other.row) == distance

  def hasDistanceInColumns(other: Location, distance: Int) = abs(column - other.column) == distance

  override def toString = s"Row: $row, column: $column"
}
