package com.venkat.scala.parallel

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global//this is implicit for Future
import io.StdIn._

/**
  * Created by venkatram.veerareddy on 8/3/2017.
  */
object FutureEx extends App{
  println("this is first print line")
  val f = Future{
    println("Printing in the future.")
  }
  println("this is last print line.")
  //readLine()
  Thread.sleep(5000)
}
