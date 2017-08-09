package com.venkat.scala.akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern._
import akka.util.Timeout

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
  * Created by venkatram.veerareddy on 8/3/2017.
  */


case object AskName
case class NameResponse(name:String)
case class AskNameOf(other: ActorRef)

class AskActor(val name: String) extends Actor{

  override def receive: Receive = {

    case AskName => sender ! NameResponse(name)

    case AskNameOf(other) =>
      implicit  val timeout = Timeout( 1 seconds)
      val f = other ? AskName
      f.onComplete{
        case Success(NameResponse(s)) =>
          println("They said their name was " + s)
        case Success(s) =>
          println("They did not tell their name " )
        case Failure(ex) =>
          println("Asking their name failed" )
      }
  }
}
object AskPattern extends App{

  val system = ActorSystem("AskActor")
  val actor = system.actorOf(Props(new AskActor("Venkatram")), "AskActor")
  val actor2 = system.actorOf(Props(new AskActor("Krishna")), "AskActor2")

  implicit  val timeout = Timeout( 1 seconds)
  val answer = actor ? AskName //gives back a future
  answer.foreach(n => println("Name is " + n))

  actor ! AskNameOf(actor2)
  system.terminate()

}
