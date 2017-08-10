package com.venkat.scala.misc.implicitclass

import com.venkat.scala.misc.dtconversions.Employee

object LateTraitImpl {

  implicit class EmpOrdering(emp:Employee) extends Ordered[Employee]{
    override def compare(that: Employee): Int = {
      emp.empId.compare(that.empId)
    }
  }

}
