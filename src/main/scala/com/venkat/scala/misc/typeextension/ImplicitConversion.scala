package com.venkat.scala.misc.typeextension

import com.venkat.scala.misc.dtconversions.Employee


object ImplicitConversion extends App{
  import TypeExtensionImplicits.empToJsObject

  val emp = new Employee("002","emp@emp.com","emp1", "emp2")

  println(emp)

  println(emp.prettyPrint)

}
