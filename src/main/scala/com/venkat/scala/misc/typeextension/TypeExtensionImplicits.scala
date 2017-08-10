package com.venkat.scala.misc.typeextension
import com.venkat.scala.misc.dtconversions.Employee
import spray.json.{JsObject, JsString}


object TypeExtensionImplicits {

  implicit def empToJsObject(emp: Employee) = JsObject(Map("empId" -> JsString(emp.empId),
                                               "email" -> JsString(emp.email),
                                               "firstName" -> JsString(emp.firstName),
                                               "lastName"->JsString(emp.lastName)))

  class JsonEmployee(emp: Employee){

    def asJsObject : JsObject = {
      empToJsObject(emp)
    }

  }

  implicit def toJsonEmp(emp:Employee) = new JsonEmployee(emp)

}
