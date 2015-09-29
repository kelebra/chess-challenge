package com.tkachuko.chess.frontend

import com.tkachuko.chess.frontend.pages.{SetupPage, PageTemplate}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

@JSExport
object Index extends js.JSApp with PageTemplate {

  @JSExport
  def main(): Unit = SetupPage.render
}
