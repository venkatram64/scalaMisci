package com.venkat.scala.cakepattern

import com.venkat.scala.misc.cakepattern.{EmployeeRepository, EmployeeRepositoryController, EmployeeService, EmployeeServiceController}
import org.scalatest.{Matchers, WordSpec}


trait TestEnvironment extends WordSpec with EmployeeRepositoryController with EmployeeServiceController with Matchers{

  override val employeeRepository: EmployeeRepository = new EmployeeStoreRepositoryController
  override val employeeService: EmployeeService = new EmployeeServiceImpl
}

class EmpTest extends TestEnvironment{

  "Should create employee" in {

    employeeService.create("user1", "user123", "user@user.com")
    val emp = employeeRepository.getByEmail("user@user.com")
    emp.isDefined shouldEqual true
    emp.get.userName shouldEqual "user1"
    employeeService.delete(emp.get.email)

  }

  "Should login with emp credentials" in {

    employeeService.create("user1", "user123", "user@user.com")
    employeeService.login("user@user.com", "user123") shouldEqual true
    employeeService.login("user@user.com", "user1234") shouldEqual false

  }

}
