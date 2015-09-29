package com.tkachuko.chess.frontend.pages

import scala.scalajs.js.annotation.JSExport
import scalatags.JsDom.all._

@JSExport
object SetupPage extends PageTemplate {

  val kings = input(`id` := "kings", `type` := "number", min := 0, max := 5)
  val queens = input(`id` := "queens", `type` := "number", min := 0, max := 5)
  val rooks = input(`id` := "rooks", `type` := "number", min := 0, max := 5)
  val bishops = input(`id` := "bishops", `type` := "number", min := 0, max := 5)
  val knights = input(`id` := "knights", `type` := "number", min := 0, max := 5)

  val width = input(`id` := "width", `type` := "number", min := 0, max := 7)
  val height = input(`id` := "height", `type` := "number", min := 0, max := 7)

  val calculateDrawPositions = button(`class` := "btn waves-effect waves-light", "Calculate all draw positions",
    i(`class` := "material-icons right", "done_all")
  )

  override def top = Seq(
    div(`class` := "row"),
    div(`class` := "row center-align",
      h4(`class` := "offset-s2 card-panel teal col s8 white-text", "Please specify parameters for challenge below:")
    )
  )

  override def body = Seq(
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
}
