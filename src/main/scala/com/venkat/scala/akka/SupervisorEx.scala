package com.venkat.scala.akka

import akka.actor.SupervisorStrategy.{Restart, Resume}
import akka.actor.{Actor, ActorSystem, OneForOneStrategy, Props}

/**
  * Created by venkatram.veerareddy on 8/4/2017.
  */

object SupervisorEx extends App{

  case object CreateChild
  case class SignalChildren(order: Int) //order
  case class PrintSignal(order: Int)  //order
  case class DivideNumber(n: Int, d:Int)
  case object BadStuff

  class ParentActor extends Actor{

    private var number = 0

    override def receive: Receive = {
      case CreateChild =>
        context.actorOf(Props[ChildActor], "Child" + number)
        number += 1
      case SignalChildren(n) =>
        context.children.foreach( _ ! PrintSignal(n))
    }

    override val supervisorStrategy = OneForOneStrategy(loggingEnabled = false){
      case ae: ArithmeticException => Resume
      case _: Exception => Restart
    }
  }

  class ChildActor extends Actor{
    override def receive: Receive = {
      case PrintSignal(n) => println(n + " " + self)
      case DivideNumber(n, d) => println(n/d)
      case BadStuff => throw new RuntimeException("Some thing bad happened.")
    }
  }

  val system = ActorSystem("HierarchySystem")
  val actor = system.actorOf(Props[ParentActor],"ParentActor")
  val actor2 = system.actorOf(Props[ParentActor],"ParentActor2")

  actor ! CreateChild
  actor ! CreateChild

  val child0 = system.actorSelection("akka://HierarchySystem/user/ParentActor/Child0")
  child0 ! DivideNumber(4,0)
  child0 ! DivideNumber(4,2)

  Thread.sleep(1000)
  system.terminate()

}
