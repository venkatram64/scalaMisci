package com.venkat.scala.misc.cakepattern

trait EmployeeService{

  def login(email: String, password: String): Boolean

  def create(userName: String, password: String, email: String): Option[String]

  def delete(emial: String): Boolean

}


trait EmployeeServiceController { this: EmployeeRepositoryController =>

  val employeeService: EmployeeService

  class EmployeeServiceImpl extends EmployeeService{

    override def login(email: String, password: String): Boolean = {
      employeeRepository.getByEmail(email) match {
        case Some(emp) if emp.password == password => true
        case _ => false
      }
    }

    override def create(userName: String, password: String, email: String): Option[String] = {
      employeeRepository.create(Employee(userName,password,email)).map(_.userName)
    }

    override def delete(email: String): Boolean = employeeRepository.deleteByEmail(email)
  }
}
