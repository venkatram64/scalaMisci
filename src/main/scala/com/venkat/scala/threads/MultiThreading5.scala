package com.venkat.scala.threads

/**
  * Created by venkatram.veerareddy on 8/2/2017.
  */
/*
  parallel processing
  concurrency
 */
object MultiThreading5{

  def main(args:Array[String]): Unit = {

    val cnts = Array.fill(10)(0)
    var cnt = 0
    val start = System.nanoTime()
    val threads = for(i <- cnts.indices) yield {
      new Thread(new Runnable {
        override def run(): Unit = {
          var c = 0
          for(j <- 1 to 100000000) {
            c += 1
          }
          MultiThreading5.synchronized{ //will happen for only for 10 threads
            cnt += c //race condition or critical block
          }
        }
      })
    }
    threads.foreach(_.start())
    threads.foreach(_.join())
    println((System.nanoTime() - start)/1e9)
    println(cnt)
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
