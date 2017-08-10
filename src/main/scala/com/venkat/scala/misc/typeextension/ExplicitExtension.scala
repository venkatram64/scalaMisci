package com.venkat.scala.misc.typeextension

import com.venkat.scala.misc.dtconversions.Employee
import com.venkat.scala.misc.typeextension.TypeExtensionImplicits.toJsonEmp

object ExplicitExtension extends App{

  val emp = new Employee("002","emp@emp.com","emp1", "emp2")
  println(emp)

  println(emp.asJsObject.prettyPrint)

}
