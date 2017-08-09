package com.venkat.scala.akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
  * Created by venkatram.veerareddy on 8/3/2017.
  */

case object CreateChild
case object SignalChildren
case object PrintSignal

class ParentActor extends Actor{

  private var number = 0
  private val children = collection.mutable.Buffer[ActorRef]()

  override def receive: Receive = {
    case CreateChild =>
      children += context.actorOf(Props[ChildActor], "Child" + number)
      number += 1
    case SignalChildren =>
      children.foreach( _ ! PrintSignal)
  }

/*  private var number = 0

  override def receive: Receive = {
    case CreateChild =>
      context.actorOf(Props[ChildActor], "Child" + number)
      number += 1
    case SignalChildren =>
      context.children.foreach( _ ! PrintSignal)
  }*/
}

class ChildActor extends Actor{
  override def receive: Receive = {
    case PrintSignal => println(self)
  }
}

object HierarchyEx extends App{

  val system = ActorSystem("HierarchySystem")
  val actor = system.actorOf(Props[ParentActor],"ParentActor")
  val actor2 = system.actorOf(Props[ParentActor],"ParentActor2")

  actor ! CreateChild
  actor ! SignalChildren
  actor ! CreateChild
  actor ! CreateChild
  actor ! SignalChildren

  actor2 ! CreateChild
  val child0 = system.actorSelection("akka://HierarchySystem/user/ParentActor2/Child0")
  child0 ! PrintSignal

  Thread.sleep(1000)
  system.terminate()
}
