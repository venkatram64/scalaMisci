package com.venkat.scala.parallel

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/**
  * Created by venkatram.veerareddy on 8/3/2017.
  */
object FutureEx4 extends App{



  val google = Future{
    "Google " + io.Source.fromURL("http://www.google.com").take(100).mkString
  }

  val fb = Future{
    "Facebook " + io.Source.fromURL("http://www.facebook.com").take(100).mkString
  }

  val youtube = Future{
    "Youtube " + io.Source.fromURL("http://www.youtube.com").take(100).mkString
  }

  val sites = List(google, fb, youtube)

  //val firstPage = Future.firstCompletedOf(sites)
  //firstPage.foreach(println)
  val allPages = Future.sequence(sites)
  allPages.foreach(println)

  Thread.sleep(5000)
}
