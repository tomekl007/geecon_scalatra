package com.tomekl007.app.actors

import akka.actor.Actor
import akka.event.Logging
import com.tomekl007.app.GeeconTalkRate

class RateAggregatorActor extends Actor{
    val log = Logging(context.system, this)
    override def receive: Receive = {
      case GeeconTalkRate(name, rate) => {
        log.info(s"receive new geccon talk rate, $name -> $rate ")
      }
    }
  }



