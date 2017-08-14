package com.venkat.scala.misc.implicitly


object Calculator extends App{
  val doubleNumbers = Vector(18.0, 33.0, 42.0, 46.0, 71.0, 79.0)
  println(Statistics.median(doubleNumbers))
  println(Statistics.change(doubleNumbers))

  val intNumbers = Vector(18, 33, 42, 46, 71, 79)
  println(Statistics.median(intNumbers))
  println(Statistics.change(intNumbers))
}
