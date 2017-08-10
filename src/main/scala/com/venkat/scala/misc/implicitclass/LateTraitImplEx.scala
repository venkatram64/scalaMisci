package com.venkat.scala.misc.implicitclass

import com.venkat.scala.misc.dtconversions.Employee


object LateTraitImplEx extends App{

  val emp1 = Employee("003","test@test.com","test","testing")
  val emp2 = Employee("004","test@test.com","test","testing")
  val emp3 = Employee("002","test@test.com","test","testing")
  val emp4 = Employee("001","test@test.com","test","testing")

  import LateTraitImpl._

  List(emp1,emp2,emp3,emp4).sorted.foreach(println)

}
