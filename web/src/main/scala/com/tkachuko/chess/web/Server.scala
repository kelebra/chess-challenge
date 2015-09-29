package com.tkachuko.chess.web

import akka.actor.ActorSystem
import akka.http.Http
import akka.stream.ActorFlowMaterializer

object Server extends App {

  implicit val system = ActorSystem()
  implicit val executor = system.dispatcher
  implicit val materializer = ActorFlowMaterializer()

  Http().bindAndHandle(Routes.handle, "0.0.0.0", 8000)
}
