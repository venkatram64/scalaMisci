package com.venkat.scala.misc.contextpassing

import java.util.Date


import scala.concurrent.{ExecutionContext, Future}


object FutureEx extends App{

  println(s"Starting the job ${new Date()}")
  implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global

  val firstOccurance: Future[Int] = Future{
    val source = scala.io.Source.fromFile("word-list.txt")
    source.toSeq.indexOfSlice("colleague")
  }

  firstOccurance.onComplete(valueTry =>{
    println(s"Completed the job${new Date()}")
    println(s"First occurance of word colleague is ${valueTry.get}")
  })

  println(s"Writing for results ${new Date()}")
  Thread.sleep(2000)

}
