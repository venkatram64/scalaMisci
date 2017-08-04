package com.venkat.scala.akka

import akka.actor.SupervisorStrategy.{Restart, Resume}
import akka.actor.{Actor, ActorSystem, OneForOneStrategy, Props}

/**
  * Created by venkatram.veerareddy on 8/4/2017.
  */

object SupervisorEx2 extends App{

  case object CreateChild
  case class SignalChildren(order: Int) //order
  case class PrintSignal(order: Int)  //order
  case class DivideByNumber(n: Int, d:Int)
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

    println("Child created.")
    override def receive: Receive = {
      case PrintSignal(n) => println(n + " " + self)
      case DivideByNumber(n, d) => println(n/d)
      case BadStuff => throw new RuntimeException("Some thing bad happened.")
    }

    override def preStart(): Unit = {
      super.preStart()
      println("preStart()")
    }

    override def postStop(): Unit = {
      super.postStop()
      println("postStop()")
    }

    override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
      super.preRestart(reason, message)
      println("preRestart()")
    }

    override def postRestart(reason: Throwable): Unit = {
      super.postRestart(reason)
      println("postRestart()")
    }

  }

  val system = ActorSystem("HierarchySystem")
  val actor = system.actorOf(Props[ParentActor],"ParentActor")
  val actor2 = system.actorOf(Props[ParentActor],"ParentActor2")

  actor ! CreateChild
  //actor ! CreateChild

  val child0 = system.actorSelection("akka://HierarchySystem/user/ParentActor/Child0")
  child0 ! DivideByNumber(4,0)
  child0 ! DivideByNumber(4,2)
  child0 ! BadStuff

  Thread.sleep(1000)
  system.terminate()

}
