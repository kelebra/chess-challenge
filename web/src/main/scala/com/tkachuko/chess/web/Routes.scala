package com.tkachuko.chess.web

import akka.http.server.Directives._

import scala.language.postfixOps

object Routes {

  val handle = {
    get {
      pathSingleSlash {
        getFromResource("html/index.html")
      } ~
        getFromResourceDirectory(".")
    }
  }
}
