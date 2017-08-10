package com.venkat.scala.misc.implicitclass
import com.venkat.scala.misc.dtconversions.Employee
import com.venkat.scala.misc.typeextension.TypeExtensionImplicits
import spray.json.JsObject


object ImplicitClass {

  implicit class JsonEmployee(emp:Employee){
    def asJsObject: JsObject = TypeExtensionImplicits.empToJsObject(emp)
  }

}
