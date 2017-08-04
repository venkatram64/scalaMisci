package com.venkat.scala.akka

import akka.actor.{Actor, ActorSystem, Props}
import scala.concurrent.duration._
//import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by venkatram.veerareddy on 8/4/2017.
  */
object SchedularEx extends App{

  case object Count

  class SchedularActor extends Actor{
    var n = 0
    override def receive: Receive = {
      case Count =>
        n += 1
        println(n)
    }
  }

  val system = ActorSystem("SchedularSystem")
  val actor = system.actorOf(Props[SchedularActor],"SchedularActor")
  implicit val ec = system.dispatcher

  actor ! Count
  system.scheduler.scheduleOnce(1.second)(actor ! Count)
  val cn = system.scheduler.schedule(0.second, 100.millis, actor, Count)

  Thread.sleep(2000)
  cn.cancel()
  system.terminate()

}
