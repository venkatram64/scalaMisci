package com.venkat.scala.misc.adhoc_polymorphism.typeclasses

import com.venkat.scala.misc.adhoc_polymorphism.typeclasses.Statistics


object Calculator extends App{

  val doubleNumbers = Vector(12.0,23.0,43.0,45.0, 62.0, 55.0)
  println(Statistics.mean(doubleNumbers))

  val initNumbers = Vector(12,23,43,45, 62, 55)
  println(Statistics.mean(initNumbers))

  val stringNumbers = Vector("12","23","43","45", "62", "55")
  //println(Statistics.mean(stringNumbers))

}
