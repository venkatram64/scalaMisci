package com.venkat.scala.implicitway

import org.scalatest.{Matchers, WordSpec}


trait TestEnvironment extends WordSpec with Matchers{
  implicit val empRepository: EmployeeRepository = new EmployeeStoreRepository
  val empService: EmployeeService = new EmployeeService
}

class EmpTest extends TestEnvironment{

  "Should create employee" in{

    empService.create("user1","user123", "user@user.com")
    val emp = empRepository.getByEamil("user@user.com")
    emp.isDefined shouldEqual true

    emp.get.userName shouldEqual "user1"
    empService.delete(emp.get.email)
  }

  "Should login employee" in {
    empService.create("user1","user123", "user@user.com")
    empService.login("user@user.com", "user123") shouldEqual true

    empService.login("user@user.com", "user1234") shouldEqual false
  }

}
