package com.venkat.scala.akka

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by venkatram.veerareddy on 8/3/2017.
  */
class SimpleActor extends Actor{

  override def receive: Receive = {
    case s: String => println("String: " + s)
    case i: Int => println("Int: " + i)

  }

  def foo = println("Normal method.")
}
object SimpleActorEx extends App{

  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(Props[SimpleActor],"SimpleActor")
  println("Before message.")
  actor ! "Hi there"
  println("Before message.")
  actor ! 51

  system.terminate()

}
