package com.venkat.scala.misc.dtconversions

import ConversionImplicits.empToJsObject

object DataTypeImplicitConversion extends App{

  val emp = Employee("001","ram@laxman.com","Ram", "Laxman")

  println(emp)

  println(emp.prettyPrint)

}
