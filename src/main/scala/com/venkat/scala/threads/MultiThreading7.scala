package com.venkat.scala.threads

import java.util.concurrent.{Callable, Executors}

/**
  * Created by venkatram.veerareddy on 8/2/2017.
  */
/*
  parallel processing
  concurrency
 */
object MultiThreading7{

  def main(args:Array[String]): Unit = {
    calcFibWithParallel
    //calcFibWithExecutor
  }

  def calcFibWithParallel: Unit = {
    val fibs = for(i <- (30 to 15 by -1).par) yield{
      fib(i)
    }

    //fibs.foreach(println)
    fibs.seq.foreach(println)
  }
  println("++++++++++++++++++++++++")
  def calcFibWithExecutor: Unit ={
    val es = Executors.newFixedThreadPool(4)
    val futures = for(i <- 30 to 15 by -1) yield {
      es.submit(new Callable[Int] {
        override def call(): Int = {
          val r = fib(i)
          println("Calc: " + r)
          r
        }
      })
    }
    futures.foreach(f => println(f.get()))
    es.shutdown()
  }

  def fib(n: Int):Int = if(n < 2) 1 else fib(n - 1) + fib(n - 2)

}
