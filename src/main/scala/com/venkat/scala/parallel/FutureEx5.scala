package com.venkat.scala.parallel

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/**
  * Created by venkatram.veerareddy on 8/3/2017.
  */
object FutureEx5 extends App{

/*  def fib(n:Int): Int = if(n < 2) 1 else fib(n -1) + fib(n-2)

  val f = Future{
    for(i <- 1 to 20) yield fib(i)

  }
  println(Await.result(f, 5 seconds))*/

  var i = 0
  for(j <- (1 to 100000000).par) i += 1
  println(i)

  //Thread.sleep(5000)
}
