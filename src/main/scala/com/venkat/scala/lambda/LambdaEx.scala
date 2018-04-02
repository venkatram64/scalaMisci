package com.venkat.scala.lambda

class LambdaEx {

  val f = (x:Double) => x * x

  val sum = (x:Double, y:Double) => x + y

}

object LambdaEx extends App{
  val lambdaEx = new LambdaEx()


  println(lambdaEx.f(5))

}
