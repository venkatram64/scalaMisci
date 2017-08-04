package com.venkat.scala.parallel

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
  * Created by venkatram.veerareddy on 8/3/2017.
  */
object FutureEx2 extends App{

  def fib(n:Int): Int = if(n < 2) 1 else fib(n -1) + fib(n-2)

  val f = Future{
    for(i <- 1 to 20) yield fib(i)
    //throw new RuntimeException("Something bad happened.")
  }
  //f.foreach(println)
  f.onComplete{
    case Success(n) => println(n)
    case Failure(ex) => println("Something went wrong. "+ ex)
  }

  Thread.sleep(5000)
}
