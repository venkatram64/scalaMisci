package com.venkat.scala.misc.dtconversions

import spray.json.{JsObject, JsString}


case class Employee(empId:String, email:String, firstName:String, lastName:String)

object ConversionImplicits {

  implicit def empToJsObject(e: Employee) = JsObject(Map("empId"->JsString(e.empId),
                                                "email"->JsString(e.email),
                                                "firstName"->JsString(e.firstName),
                                                 "lastName" -> JsString(e.lastName)))
}
