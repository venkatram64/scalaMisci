package com.venkat.scala.misc.cakepattern

object EmployeeStore extends EmployeeServiceController with EmployeeRepositoryController{

  val employeeService: EmployeeService = new EmployeeServiceImpl
  val employeeRepository: EmployeeRepository = new EmployeeStoreRepositoryController

  def main(args: Array[String]): Unit ={

    employeeService.create("user1","user123", "user@user.com")
    println(employeeService.login("user@user.com", "user123"))
    println(employeeService.login("user@user.com", "user1123"))

  }

}
