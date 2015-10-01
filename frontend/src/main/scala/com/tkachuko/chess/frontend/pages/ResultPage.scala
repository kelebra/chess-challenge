package com.tkachuko.chess.frontend.pages

import com.tkachuko.chess.Location
import com.tkachuko.chess.board.BoardView
import com.tkachuko.chess.figures._
import org.scalajs.dom._

import scala.scalajs.js.annotation.JSExport
import scalatags.JsDom.all._

@JSExport
object ResultPage extends PageTemplate {

  val figureToSymbolMapping: Map[ChessFigure, String] = Map(
    King -> "♔",
    Queen -> "♕",
    Rook -> "♖",
    Bishop -> "♗",
    Knight -> "♘"
  )

  override val top = Seq(
    div(`class` := "row"),
    div(`class` := "row center-align",
      h4(`class` := "offset-s2 card-panel teal col s8 white-text", "Please see all board below:")
    )
  )

  def render(boards: Set[BoardView]): Unit = {
    render()
    boards.map(toHtml).foreach(table => document.body.children.item(1).appendChild(table))
  }

  def toHtml(view: BoardView): Node = {
    val board = Array.tabulate(view.height, view.width) {
      (row, column) => view.figures.get(Location(row, column)).flatMap(figureToSymbolMapping.get).getOrElse("")
    }
    val offset = 12 - view.width
    div(`class` := s"row",
      board.map(
        row => div(`class` := s"row", style := "margin-bottom: 0px;",
          row.map(cell =>
            div(`class` := s"col s1",
              style := "border:1px solid black;text-align:center;width:80px;height:80px;line-height:80px",
              cell
            )
          )
        )
      )
    ).render
  }
}
