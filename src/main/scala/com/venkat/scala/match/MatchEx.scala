package com.venkat.scala.`match`

class MatchEx {
  /*
  expression match {
    case pattern1 => ...
    case patern2 => ...
  }
   */
  def fact(n: Int): Int = n match {
    case 0 => 1
    case _ => n * fact(n-1)
  }

  def sumOfSqures(n: Int): Int = n match {
    case 0 => 1
    case _ => n * sumOfSqures(n-1)
  }

  def countDown(n: Int): Unit = n match {
    case 0 =>
    case _ =>
      println(n)
      countDown(n-1)
  }

}

object MatchEx extends App{
  val matcher = new MatchEx()
  println(matcher.fact(5))
  println(matcher.sumOfSqures(4))
  println(matcher.countDown(5))
}
