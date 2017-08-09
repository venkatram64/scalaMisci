package com.venkat.scala.implicitway


object EmpStoreTest {

  implicit val empRepository: EmployeeRepository = new EmployeeStoreRepository
  val empService = new EmployeeService

  def main(args: Array[String]): Unit ={
    empService.create("user1","user123", "user@user.com")
    println(empService.login("user@user.com","user123"))
    println(empService.login("user@user.com","user1234"))
  }

}
