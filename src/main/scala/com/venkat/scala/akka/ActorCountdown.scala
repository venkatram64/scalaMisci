package com.venkat.scala.akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}


/**
  * Created by venkatram.veerareddy on 8/3/2017.
  */
class CountdownActor extends Actor{
  import com.venkat.scala.akka.ActorCountdown._

  override def receive: Receive = {
    case StartCounting(n, other) =>
      println(n)
      other ! CountDown(n-1)
    case CountDown(n) =>
      println(self)
      if(n > 0){
        println (n)
        sender ! CountDown(n-1)
      }else{
        context.system.terminate()
      }

  }


}

object ActorCountdown extends App{

  case class StartCounting(n: Int, other: ActorRef)
  case class CountDown(n: Int)

  val system = ActorSystem("CountdownActor")
  val actor = system.actorOf(Props[CountdownActor],"CountdownActor")
  val actor2 = system.actorOf(Props[CountdownActor],"CountdownActor2")
  println("Before message.")
  actor ! StartCounting(10, actor2)


  system.terminate()
}
