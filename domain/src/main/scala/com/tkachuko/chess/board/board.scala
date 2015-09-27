package com.tkachuko.chess

import com.tkachuko.chess.figures.ChessFigure

package object board {

  // TODO: Should do something with locations in matrix. Looks stupid as you always have indexes.
  type Cells = Array[Array[Cell]]

  implicit class CellsDSL(cells: Cells) {

    def put(figure: ChessFigure, location: Location): Unit = {
      val row = location.row
      val column = location.column
      val cellRow = cells(row)
      val cell = cellRow(column)
      if (cell.isEmpty)
        cellRow.update(column, cell.copy(figure = Option(figure)))
      else
        throw new IllegalStateException(s"Not allowed to overwrite figure in the cell ($location)")
    }
  }

  case class Board(cells: Cells) {

    def put(figure: ChessFigure, location: Location): Unit = cells.put(figure, location)
  }

  object Board {

    def apply(rows: Int, columns: Int) = new Board(
      Array.tabulate(rows, columns) { (row, column) => Cell(Location(row, column)) }
    )
  }

  // TODO: probably can be removed for sake of memory efficiency
  final case class Cell(location: Location, figure: Option[ChessFigure] = None) {

    def isEmpty = figure.isEmpty
  }

}
