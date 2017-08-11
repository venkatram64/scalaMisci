package com.venkat.scala.misc.contextpassing

import java.util.Date
import java.util.concurrent.Executor

import scala.concurrent.{ExecutionContext, Future}


object FutureExSameThread extends App{

  implicit val currentThreadExecutionContext = ExecutionContext.fromExecutor(
    new Executor{
      override def execute(command: Runnable): Unit = {
        command.run()
      }
    }
  )

  println(s"Starting the job ${new Date()}")
  val firstOccurrence: Future[Int] = Future{
    val source = scala.io.Source.fromFile("word-list.txt")
    source.toSeq.indexOfSlice("paso")
  }

  firstOccurrence.onComplete(valueTry=>{
    println(s"Completed the job ${new Date()}")
    println(s"First occurrence of work paso is  ${valueTry.get}")
  })

  println(s"Waiting for results ${new Date()}")

}
