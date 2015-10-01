package com.tkachuko.chess

package object figures {

  type AttackRule = (Location, Location) => Boolean

  sealed trait ChessFigure {

    val alias: Char

    def attackRule(from: Location)(to: Location): Boolean

    def canAttack(from: Location): Location => Boolean = attackRule(from)

    override def toString = alias.toString
  }

  case object Bishop extends ChessFigure {

    val alias = 'B'

    def attackRule(from: Location)(to: Location) = from.sharesDiagonalWith(to)
  }

  case object King extends ChessFigure {

    val alias = 'K'

    def attackRule(from: Location)(to: Location) = (
      (from.sharesAdjacentColumnWith(to) && from.sharesRowWith(to)) ||
        (from.sharesAdjacentRowWith(to) && from.sharesColumnWith(to))
      ) ||
      from.sharesDiagonalWith(to, 1)
  }

  case object Knight extends ChessFigure {

    val alias = 'N'

    def attackRule(from: Location)(to: Location) =
      (from.hasDistanceInRows(to, 2) && from.hasDistanceInColumns(to, 1)) ||
        (from.hasDistanceInRows(to, 1) && from.hasDistanceInColumns(to, 2))
  }

  case object Queen extends ChessFigure {

    val alias = 'Q'

    def attackRule(from: Location)(to: Location) =
      from.sharesDiagonalWith(to) || from.sharesRowWith(to) || from.sharesColumnWith(to)
  }

  case object Rook extends ChessFigure {

    val alias = 'R'

    def attackRule(from: Location)(to: Location) = from.sharesRowWith(to) || from.sharesColumnWith(to)
  }

}
