package com.tkachuko.chess

import com.tkachuko.chess.figures.ChessFigure

package object board {

  case class Board(
                    height: Int,
                    width: Int,
                    freeCells: Seq[Location],
                    figures: Map[Location, ChessFigure]) {

    def put(figure: ChessFigure, location: Location): Option[Board] =
      if (freeCells.isEmpty ||
        figures.contains(location) ||
        conflictsWithExistingFigures(figure, location)
      ) None
      else Option(
        copy(
          freeCells = freeCells filterNot { cell => figure.canAttack(location)(cell) || cell == location },
          figures = figures + (location -> figure)
        )
      )

    def conflictsWithExistingFigures(figure: ChessFigure, location: Location) =
      figures.keys.exists(figure.canAttack(location))

    def view = BoardView(height, width, figures)
  }

  object Board {

    def apply(height: Int, width: Int) = {
      val cells = for {
        row <- 0 until height
        column <- 0 until width
      } yield Location(row, column)
      new Board(height, width, cells, Map())
    }
  }

  case class BoardView(height: Int, width: Int, figures: Map[Location, ChessFigure])

}
