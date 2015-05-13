package com.tomekl007.app

import akka.actor.ActorSystem
import com.tomekl007.app.controller.GeeconController
import org.scalatest.FunSuite
import org.scalatra.test.scalatest.ScalatraSuite

class GeeconControllerSpec extends FunSuite with ScalatraSuite {
  implicit val system = ActorSystem()

  addServlet(new GeeconController(), "/*")

  test("") {
    get(s"path") {

    }
  }

}
