package com.tkachuko.chess.frontend.pages

import Elements._
import scalatags.JsDom
import scalatags.JsDom.all._
import org.scalajs.dom._

trait PageTemplate {

  type Element = JsDom.Modifier
  type Elements = Seq[Element]

  def top: Elements = Seq.empty[Element]

  def body: Elements = Seq.empty[Element]

  def bottom: Elements = Seq.empty[Element]

  def render = {
    document.body.innerHTML = ""
    document.body.appendChild(
      header(top: _*).render
    )
    document.body.appendChild(
      main(body: _*).render
    )
    document.body.appendChild(
      footer(bottom: _*).render
    )
  }
}
