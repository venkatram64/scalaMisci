package com.venkat.scala.parallel

/**
  * Created by venkatram.veerareddy on 8/3/2017.
  */
object ParallelCollect extends App{

  def fib(n:Int): Int = if(n < 2) 1 else fib(n -1) + fib(n-2)

  for(i <- (30 to 10 by -1).par){
    println(fib(i))
  }

  var i = 0
  for(j <- (1 to 100000000).par) i += 1
  println(i)

}
