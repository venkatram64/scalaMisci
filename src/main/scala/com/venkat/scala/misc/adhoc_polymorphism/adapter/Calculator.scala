package com.venkat.scala.misc.adhoc_polymorphism.adapter

import com.venkat.scala.misc.adhoc_polymorphism.adapter.Statistics.{NumberLikeDouble, NumberLikeInt}


object Calculator extends App{

  val doubleNumbers = Vector(NumberLikeDouble(14), NumberLikeDouble(22.0), NumberLikeDouble(56),
                  NumberLikeDouble(34),NumberLikeDouble(76),NumberLikeDouble(77))

  println(Statistics.mean(doubleNumbers))

  val intNumbers = Vector(NumberLikeInt(14), NumberLikeInt(22.0), NumberLikeInt(56),
                 NumberLikeInt(34),NumberLikeInt(76),NumberLikeInt(77))

  println(Statistics.mean(intNumbers))

}
