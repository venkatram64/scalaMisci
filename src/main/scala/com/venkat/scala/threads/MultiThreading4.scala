package com.venkat.scala.threads

import java.util.concurrent.atomic.AtomicInteger

/**
  * Created by venkatram.veerareddy on 8/2/2017.
  */
/*
  parallel processing
  concurrency
 */
object MultiThreading4{

  def main(args:Array[String]): Unit = {

    val cnts = Array.fill(10)(0)
    val start = System.nanoTime()
    val threads = for(i <- cnts.indices) yield {
      new Thread(new Runnable {
        override def run(): Unit = {
          var c = 0 //local variable
          for(j <- 1 to 100000000) {
            c += 1//race condition or critical block
          }
          cnts(i) += c
        }
      })
    }
    threads.foreach(_.start()) //all threads are started
    threads.foreach(_.join()) //all threads are joined
    println((System.nanoTime() - start)/1e9)
    println(cnts.sum)
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
