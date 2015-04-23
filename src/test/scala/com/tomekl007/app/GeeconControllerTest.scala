package com.tomekl007.app

import akka.actor.{Props, ActorSystem}
import com.tomekl007.app.actors.RateAggregatorActor
import com.tomekl007.app.controller.GeeconController
import org.scalatest.FunSuite
import org.scalatra.test.scalatest.ScalatraSuite


class GeeconControllerTest extends FunSuite with ScalatraSuite {

  val system = ActorSystem()
  val meetupActor = system.actorOf(Props[RateAggregatorActor], name="rateAggregator")

  addServlet(new GeeconController(system, meetupActor), "/*")

  var aboutParam = "scala"
  test("geecon talk should be about scala") {
    get(s"/geecon/talk/$aboutParam") {
      status should equal (200)
      body should include (aboutParam)
    }
  }

}

