package com.tkachuko.chess.web

import akka.actor.ActorSystem
import akka.http.Http
import akka.http.model.HttpResponse
import akka.http.server.Directives._
import akka.stream.ActorFlowMaterializer
import com.tkachuko.chess.challenge.Challenge
import com.tkachuko.chess.web.messages.ChallengeInput
import upickle.default._

import scala.util.Try

object Server extends App {

  implicit val system = ActorSystem()
  implicit val executor = system.dispatcher
  implicit val materializer = ActorFlowMaterializer()

  val routes = get {
    pathSingleSlash {
      getFromResource("html/index.html")
    } ~
      getFromResourceDirectory(".")
  } ~
    (post & entity(as[String])) { input =>
      val challengeInput = Try(read[ChallengeInput](input))
      complete {
        challengeInput.toOption match {
          case Some(in) =>
            HttpResponse(entity = write(Challenge.allDrawPositions(in.figures, in.height, in.width)))
          case _ =>
            HttpResponse(entity = "Could not parse entity on server")
        }
      }
    }

  Http().bindAndHandle(routes, "0.0.0.0", 8000)
}
