package com.tomekl007.app.controller

import akka.actor.ActorRef
import com.tomekl007.app.GeeconTalkRate
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.ScalatraServlet
import org.scalatra.json.JacksonJsonSupport

class GeeconController(actor:ActorRef) extends ScalatraServlet with JacksonJsonSupport{
  override protected implicit def jsonFormats: Formats = DefaultFormats.withBigDecimal

  get("/geecon/talk/:about"){
    val talkAbout = params("about")
    val localization = params.getOrElse("localization", "Cinema")

    s"Hello from geecon talk about $talkAbout, that took place in $localization"
  }

  put("/geecon/talk/:about/:rate"){
    val talkAbout = params("about")
    val rate = params("rate")
    
    actor ! GeeconTalkRate(talkAbout, rate.toInt)
  }

}
