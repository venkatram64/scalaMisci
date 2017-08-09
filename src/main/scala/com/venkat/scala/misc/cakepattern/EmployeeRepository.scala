package com.venkat.scala.misc.cakepattern

import scala.collection.concurrent.TrieMap


case class Employee(userName: String, password: String, email:String)

trait EmployeeRepository {
  def getByEmail(email: String): Option[Employee]
  def deleteByEmail(email: String): Boolean
  def create(emp: Employee): Option[Employee]

}

trait EmployeeRepositoryController{

  val employeeRepository: EmployeeRepository

  class EmployeeStoreRepositoryController extends EmployeeRepository {

    private val emps = TrieMap[String,Employee]()

    override def getByEmail(email: String): Option[Employee] = {
      emps.get(email)
    }

    override def deleteByEmail(email: String): Boolean = {
      emps.remove(email).isDefined
    }

    override def create(emp: Employee): Option[Employee] = {
      emps.put(emp.email,emp)
    }

  }

}
