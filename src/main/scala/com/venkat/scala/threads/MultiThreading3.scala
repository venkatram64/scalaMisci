package com.venkat.scala.threads

import java.util.concurrent.atomic.AtomicInteger

/**
  * Created by venkatram.veerareddy on 8/2/2017.
  */
/*
  parallel processing
  concurrency
 */
object MultiThreading3{

  def main(args:Array[String]): Unit = {

    var cnt = new AtomicInteger(0)

    val start = System.nanoTime()
    val threads = for(i <- 1 to 10) yield {
      new Thread(new Runnable {
        override def run(): Unit = {
          for(j <- 1 to 100000000) {
            cnt.addAndGet(1) //race condition or critical block
          }
        }
      })
    }
    threads.foreach(_.start())
    threads.foreach(_.join())
    println((System.nanoTime() - start)/1e9)
    println(cnt.get())
  }
}

/*
  Deadlock

  Thread 1
    A.synchronized{
      '''''
      B.synchronized{
        '''''
      }
      '''''
    }

  Thread 2
    B.synchronized{
      '''''
      A.synchronized{
        '''''
      }
      '''''
    }
 */
