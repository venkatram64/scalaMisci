package com.venkat.scala.misc.implicitclass

import com.venkat.scala.misc.dtconversions.Employee


object ImplicitClassEx extends App{

  val emp = Employee("003","test@test.com","test","testing")

  println(emp)

  import ImplicitClass._
  println(emp.asJsObject.prettyPrint)

}
