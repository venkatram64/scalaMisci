package com.venkat.scala.model.kafka

import play.api.libs.json._
import scala.collection.mutable.ArrayBuffer

case class Employee(firstName: String,
                    lastName: String,
                    email: String)


class EmployeeImplicits {
  implicit val emp = new Writes[Employee]{
    def writes(e: Employee): JsValue = {
      Json.obj(
        "firstName" -> e.firstName,
        "lastName" -> e.lastName,
        "email" -> e.email
      )
    }
  }

  def getJsonStr(emp: ArrayBuffer[Employee]) : String = {
    Json.toJson(emp).toString()
  }
}

//new EmployeeImplicits().getJsonStr(response)
