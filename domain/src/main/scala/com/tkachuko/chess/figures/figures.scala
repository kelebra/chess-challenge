package com.tkachuko.chess

package object figures {

  type AttackRule = (Location, Location) => Boolean

  abstract sealed class ChessFigure(alias: Char, attackRule: AttackRule) {

    def canAttack(from: Location): Location => Boolean = attackRule.curried(from)

    override def toString = alias.toString
  }

  case object Bishop extends ChessFigure('B',
    (from: Location, to: Location) => from.sharesDiagonalWith(to)
  )

  case object King extends ChessFigure('K', (from: Location, to: Location) =>
    (from.sharesAdjacentColumnWith(to) || from.sharesAdjacentRowWith(to)) ||
      from.sharesDiagonalWith(to, 1)
  )

  case object Knight extends ChessFigure('N', (from: Location, to: Location) =>
    (from.hasDistanceInRows(to, 2) && from.hasDistanceInColumns(to, 1)) ||
      (from.hasDistanceInRows(to, 1) && from.hasDistanceInColumns(to, 2))
  )

  case object Queen extends ChessFigure('Q', (from: Location, to: Location) =>
    from.sharesDiagonalWith(to) || from.sharesRowWith(to) || from.sharesColumnWith(to)
  )

  case object Rook extends ChessFigure('R', (from: Location, to: Location) =>
    from.sharesRowWith(to) || from.sharesColumnWith(to)
  )

}
