package com.venkat.scala.recursion

class Counter {

  def countUp(n: Int): Unit = {
    if(n > 0){
      countUp(n - 1)
      println(n)
    }
  }

  def countDown(n: Int): Unit = {
    if(n > 0){
      println(n)
      countDown(n-1)
    }
  }

}

object Counter extends App {
  val counter = new Counter()
  counter.countDown(5)
  println("_______________")
  counter.countUp(5)
}
