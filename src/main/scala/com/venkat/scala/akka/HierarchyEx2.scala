package com.venkat.scala.akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
  * Created by venkatram.veerareddy on 8/3/2017.
  */

case object CreateChild2
case class SignalChildren2(order: Int) //order
case class PrintSignal2(order: Int)  //order

class ParentActor2 extends Actor{


  private var number = 0

  override def receive: Receive = {
    case CreateChild2 =>
      context.actorOf(Props[ChildActor2], "Child" + number)
      number += 1
    case SignalChildren2(n) =>
      context.children.foreach( _ ! PrintSignal2(n))
  }
}

class ChildActor2 extends Actor{
  override def receive: Receive = {
    case PrintSignal2(n) => println(n + " " + self)
  }
}

object HierarchyEx2 extends App{

  val system = ActorSystem("HierarchySystem")
  val actor = system.actorOf(Props[ParentActor2],"ParentActor")
  val actor2 = system.actorOf(Props[ParentActor2],"ParentActor2")

  actor ! CreateChild2
  actor ! SignalChildren2(1)
  actor ! CreateChild2
  actor ! CreateChild2
  actor ! SignalChildren2(2)

  actor2 ! CreateChild2
  val child0 = system.actorSelection("akka://HierarchySystem/user/ParentActor2/Child0")
  child0 ! PrintSignal2(3)

  Thread.sleep(1000)
  system.terminate()
}
