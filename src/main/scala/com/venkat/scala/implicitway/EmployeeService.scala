package com.venkat.scala.implicitway

/**
  * Created by venkatram.veerareddy on 8/9/2017.
  */
class EmployeeService {

  def login(email: String, password: String)(implicit empRepository: EmployeeRepository): Boolean = {
    empRepository.getByEamil(email) match {
      case Some(emp) if emp.password == password => true
      case _ => false
    }
  }

  def delete(email: String)(implicit empRepository: EmployeeRepository): Boolean = empRepository.delete(email)

  def create(userName: String, password: String, email: String)(implicit empRepository: EmployeeRepository): Option[String] = {
    empRepository.create(Employee(userName,password,email)).map(_.userName)
  }

}
