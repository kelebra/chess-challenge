package com.tkachuko.chess

import com.tkachuko.chess.figures.ChessFigure

package object board {

  type Cells = Array[Array[Option[ChessFigure]]]

  implicit class CellsDSL(cells: Cells) {

    def put(figure: ChessFigure, location: Location): Unit = {
      val row = location.row
      val column = location.column
      val cellRow = cells(row)
      val cell = cellRow(column)
      if (cell.isEmpty) cellRow.update(column, Option(figure))
      else throw new IllegalStateException(s"Not allowed to overwrite figure in the cell ($location)")
    }
  }

  case class Board(cells: Cells) {

    lazy val height = cells.length

    lazy val width = cells(0).length

    def put(figure: ChessFigure, location: Location): Unit = cells.put(figure, location)

    def clear = Board(height, width)

    def view = {
      val figures = for {
        row <- 0 until height
        column <- 0 until width
        figure <- cells(row)(column)
      } yield (Location(row, column), figure)

      BoardView(height, width, figures.toMap)
    }
  }

  object Board {

    def apply(rows: Int, columns: Int) = new Board(
      Array.tabulate(rows, columns) { (row, column) => None }
    )
  }

  case class BoardView(height: Int, width: Int, figures: Map[Location, ChessFigure])

}
