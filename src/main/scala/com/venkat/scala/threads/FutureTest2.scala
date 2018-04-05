package com.venkat.scala.threads

import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits._

import scala.concurrent.duration._

object FutureTest2 extends App{

  val page1 = Future {
    "Google " + io.Source.fromURL("http://www.goole.com").take(100).mkString
  }

  val page2 = Future {
    "Facebook " + io.Source.fromURL("http://www.facebook.com").take(100).mkString
  }

  val page3 = Future {
    "Youtube " + io.Source.fromURL("http://www.youtube.com").take(100).mkString
  }

  val pages = List(page1, page2, page3)

  /*val firstPage = Future.firstCompletedOf(pages)

  firstPage.foreach(println)
*/

  val allPages = Future.sequence(pages)

  allPages.foreach(println)

  Thread.sleep(5000)

}
