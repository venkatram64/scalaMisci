package com.venkat.scala.threads

/**
  * Created by venkatram.veerareddy on 8/2/2017.
  */
/*
  parallel processing
  concurrency
 */
object MultiThreading2{

  def main(args:Array[String]): Unit = {
    var count = 0
    val start = System.nanoTime()
    val threads = for(i <- 1 to 10) yield {  //10 threads are spawned
      new Thread(new Runnable {
        override def run(): Unit = {
          for(j <- 1 to 100000000) MultiThreading2.synchronized{//blocking
            count += 1 //race condition
          }
        }
      })
    }
    threads.foreach(_.start()) //all threads are started
    threads.foreach(_.join()) //waited to join all threads
    println((System.nanoTime() - start)/1e9) // in seconds
    println(count)
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
