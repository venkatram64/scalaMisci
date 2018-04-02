package com.venkat.scala.lambda

class Combiner {
  def combine(x:Double, y:Double, z:Double, f:(Double,Double)=>Double):Double = f(x, f(y,z))

  //using higher order function
  def sumDoubles(a: Double, b: Double, c: Double) = combine(a, b, c, (a,b) => a + b)
  def sumDoubles2(a: Double, b: Double, c: Double) = combine(a, b, c, _ + _)
}

object Combiner extends App{
  val combiner = new Combiner()
  println(combiner.sumDoubles(12,14,15))
  println(combiner.sumDoubles2(12,14,15))
}
