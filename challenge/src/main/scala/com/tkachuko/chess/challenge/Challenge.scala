package com.tkachuko.chess.challenge

import com.tkachuko.chess.Location
import com.tkachuko.chess.board.{Board, BoardView}
import com.tkachuko.chess.figures._

object Challenge {

  def allDrawPositions(figures: List[ChessFigure],
                       height: Int,
                       width: Int): Set[BoardView] =
    placeFiguresOn(figures, List(Board(height, width))).map(_.view)

  private def placeFiguresOn(figures: List[ChessFigure], acc: List[Board]): Set[Board] =
    figures match {
      case figure :: remaining => placeFiguresOn(remaining, placeFigureOn(figure, acc))
      case Nil => acc.toSet
    }

  private def placeFigureOn(figure: ChessFigure,
                            boards: List[Board],
                            acc: Set[Board] = Set()): List[Board] =
    boards match {
      case board :: remaining =>
        placeFigureOn(figure, remaining, acc ++ placeFigureOnFreeCells(figure, board, board.freeCells.toList))
      case Nil => acc.toList
    }

  private def placeFigureOnFreeCells(figure: ChessFigure,
                                     board: Board,
                                     freeCells: List[Location],
                                     acc: List[Board] = List()): List[Board] = {
    freeCells match {
      case freeCell :: remaining =>
        val updatedBoard = board.put(figure, freeCell)
        placeFigureOnFreeCells(figure, board, remaining, acc ::: updatedBoard.toList)

      case Nil => acc
    }
  }

  def main(args: Array[String]): Unit = {
    val started = System.currentTimeMillis()
    val drawPositions = allDrawPositions(King :: King :: Queen :: Queen :: Bishop :: Bishop :: Knight :: Nil, 7, 7).size
    println(s"Number of draw positions in challenge: $drawPositions")
    println(s"Time spent: ${System.currentTimeMillis() - started}")
  }
}
