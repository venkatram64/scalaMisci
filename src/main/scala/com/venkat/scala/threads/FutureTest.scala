package com.venkat.scala.threads

import io.StdIn._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits._
import scala.util.{Failure, Success}

//https://www.youtube.com/watch?v=auQrWAKa3GA&index=4&list=PLLMXbkbDbVt98z_6KWt3fU3W5jTOja9zY

object FutureTest extends App{

  println("this is the first print line.")
  val f = Future{
    println("Hello future")
  }

  println("this is the first second line.")

  val f2 = Future{
    for(i <- 1 to 30) yield MultiThreading7.fib(i)
  }

  //f2.foreach(println)
  f2.onComplete{
    case Success(n) => println(n)
    case Failure(ex) => println("Something went wrong. ", ex)
  }

  readLine()

}
