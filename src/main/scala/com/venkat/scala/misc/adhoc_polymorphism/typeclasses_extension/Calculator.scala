package com.venkat.scala.misc.adhoc_polymorphism.typeclasses_extension

import com.venkat.scala.misc.adhoc_polymorphism.typeclasses.Math.NumberLike
import com.venkat.scala.misc.adhoc_polymorphism.typeclasses.Statistics
import spray.json._


object JsonNumberImplicits{
  implicit object NumberLikeJsNumber extends NumberLike[JsNumber]{

    override def plus(x: JsNumber, y: JsNumber): JsNumber = JsNumber(x.value + y.value)

    override def divide(x: JsNumber, y: Int): JsNumber = JsNumber(x.value/y)

    override def minus(x: JsNumber, y: JsNumber): JsNumber = JsNumber(x.value - y.value)

  }
}


object Calculator extends App{

  import JsonNumberImplicits.NumberLikeJsNumber

  val jsonNumber:Vector[JsNumber] = Vector(JsNumber(12.0),JsNumber(20.0),JsNumber(23.0),JsNumber(43.0),JsNumber(45.0), JsNumber(62.0), JsNumber(55.0))
  println(Statistics.mean(jsonNumber))

  println(Statistics.mean(jsonNumber)(JsonNumberImplicits.NumberLikeJsNumber))
}
