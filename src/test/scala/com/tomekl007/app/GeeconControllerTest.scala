package com.tomekl007.app

import akka.actor.ActorSystem
import akka.testkit.TestProbe
import com.tomekl007.app.controller.GeeconController
import org.scalatest.FunSuite
import org.scalatra.test.scalatest.ScalatraSuite


class GeeconControllerTest extends FunSuite with ScalatraSuite {
  implicit val system = ActorSystem()
  val probe = TestProbe()

  addServlet(new GeeconController(probe.ref), "/*")

  var aboutParam = "scala"
  test("geecon talk should be about scala") {
    get(s"/geecon/talk/$aboutParam") {
      status should equal (200)
      body should include (aboutParam)
    }
  }
  
  test("should send message to actor when rating geecon talk"){
    val talkAbout = "scalatra"
    val rate = 10
    put(s"/geecon/talk/$talkAbout/$rate") {
      status should equal (200)
      probe.expectMsg(GeeconTalkRate(talkAbout, rate))
    }
  }

}

