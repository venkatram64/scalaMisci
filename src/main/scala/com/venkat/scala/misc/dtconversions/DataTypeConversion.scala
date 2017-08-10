package com.venkat.scala.misc.dtconversions


object DataTypeConversion extends App{
  val emp = Employee("001","test@test.com","ram","laxman")
  println(emp)
  println(ConversionImplicits.empToJsObject(emp).prettyPrint)
}
