package com.venkat.scala.hof

/**
  * Created by Venkatram on 9/23/2017.
  */
class HigherOrderFunc {

  //higher order function
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if(a > b) 0
    else f(a) + sum(f, a + 1, b)
  }
  //above recursion can be rewritten as tail recursion
  def sumTailRecurstion(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if(a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }
  //individual function definitions
  def id(x: Int): Int = x
  def cube(x: Int): Int = x * x * x
  def fact(x: Int): Int = if(x == 0) 1 else x * fact(x - 1)
  //a funtion that raises its argument to a cube
  // (x: Int) => x * x *x

  //using higher order function
  def sumInts(a: Int, b: Int) = sum(id, a, b)
  //def sumInts(a: Int, b: Int) = sum(x => x, a, b)
  def sumCubes(a: Int, b: Int) = sum(cube, a, b)
  //def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
  def sumFactorials(a: Int, b: Int) = sum(fact, a, b)
}

object HigherOrderFunc extends App{

  val hof = new HigherOrderFunc()

  //println(hof.sumInts(1,4))
  //println(hof.sumCubes(1,4))
  println(hof.fact(5))
  println(hof.sumFactorials(1,5))

}
