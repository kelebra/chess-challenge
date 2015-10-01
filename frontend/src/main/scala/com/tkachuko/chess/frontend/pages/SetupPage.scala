package com.tkachuko.chess.frontend.pages

import com.tkachuko.chess.board.BoardView
import upickle.default._
import com.tkachuko.chess.figures._
import com.tkachuko.chess.web.messages.ChallengeInput
import org.scalajs.dom.ext.Ajax
import org.scalajs.dom.html.Input
import org.scalajs.dom.raw.MouseEvent

import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.annotation.JSExport
import scalatags.JsDom.all._

@JSExport
object SetupPage extends PageTemplate {

  lazy val kings = input(`id` := "kings", `type` := "number", min := 0, max := 5).render
  lazy val queens = input(`id` := "queens", `type` := "number", min := 0, max := 5).render
  lazy val rooks = input(`id` := "rooks", `type` := "number", min := 0, max := 5).render
  lazy val bishops = input(`id` := "bishops", `type` := "number", min := 0, max := 5).render
  lazy val knights = input(`id` := "knights", `type` := "number", min := 0, max := 5).render

  lazy val width = input(`id` := "width", `type` := "number", min := 0, max := 7).render
  lazy val height = input(`id` := "height", `type` := "number", min := 0, max := 7).render

  lazy val calculateDrawPositions = button(`class` := "btn waves-effect waves-light", "Calculate all draw positions",
    i(`class` := "material-icons right", "done_all")
  ).render

  calculateDrawPositions.onclick = (m: MouseEvent) => {
    fetchBoards(
      height.value.toInt,
      width.value.toInt,
      figures(King, kings) ::: figures(Queen, queens)
        ::: figures(Rook, rooks) ::: figures(Bishop, bishops)
        ::: figures(Knight, knights)
    )
  }

  override val top = Seq(
    div(`class` := "row"),
    div(`class` := "row center-align",
      h4(`class` := "offset-s2 card-panel teal col s8 white-text", "Please specify parameters for challenge below:")
    )
  )

  override val body = Seq(
    div(`class` := "row",
      div(`class` := "input-field col s2 offset-s1",
        kings,
        label(`for` := "kings", fontSize := "18", "♚")
      ),
      div(`class` := "input-field col s2",
        queens,
        label(`for` := "queens", fontSize := "18", "♛")
      ),
      div(`class` := "input-field col s2",
        rooks,
        label(`for` := "rooks", fontSize := "18", "♜")
      ),
      div(`class` := "input-field col s2",
        bishops,
        label(`for` := "bishops", fontSize := "18", "♝")
      ),
      div(`class` := "input-field col s2",
        knights,
        label(`for` := "knights", fontSize := "18", "♞")
      )
    ),
    div(`class` := "row",
      div(`class` := "input-field col s3 offset-s3",
        i(`class` := "material-icons prefix", "swap_horiz"),
        width,
        label(`for` := "width", "Board width")
      ),
      div(`class` := "input-field col s3",
        i(`class` := "material-icons prefix", "swap_vert"),
        height,
        label(`for` := "height", "Board height")
      )
    ),
    div(`class` := "row center-align", calculateDrawPositions)
  )

  def figures(chessFigure: ChessFigure, amount: Input) = {
    val value = amount.value
    if (value.isEmpty) List.empty
    else 0 until value.toInt map { _ => chessFigure } toList
  }

  def fetchBoards(height: Int, width: Int, figures: List[ChessFigure]): Unit = {
    val serialized = write(ChallengeInput(height, width, figures))
    g.console.log(serialized)
    Ajax.post(
      url = s"${href.name}",
      data = serialized
    ).onSuccess { case xhr =>
      if (xhr.status == 200)
        ResultPage.render(read[Set[BoardView]](xhr.responseText))
    }
  }
}
