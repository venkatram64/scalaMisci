package com.venkat.scala.threads

/**
  * Created by venkatram.veerareddy on 8/2/2017.
  */
/*
  parallel processing
  concurrency
 */
object MultiThreading extends App{

  new Thread(new Runnable {
    override def run(): Unit = {
      for(i <- 1 to 10){
        println(i)
        Thread.sleep(200)
      }
    }
  }).start()

  for(c <- 'A' to 'Z'){
    println(c)
    Thread.sleep(100)
  }

}
