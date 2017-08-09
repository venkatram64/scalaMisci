package com.venkat.scala.implicitway

import scala.collection.concurrent.TrieMap

case class Employee(userName: String, password: String, email: String)

trait EmployeeRepository {
  def getByEamil(email: String): Option[Employee]
  def delete(email: String): Boolean
  def create(emp: Employee): Option[Employee]

}

class EmployeeStoreRepository extends EmployeeRepository{

  private val emps = TrieMap[String,Employee]()

  override def getByEamil(email: String): Option[Employee] = {
    emps.get(email)
  }

  override def delete(email: String): Boolean = {
    emps.remove(email).isDefined
  }

  override def create(emp: Employee): Option[Employee] = {
    emps.put(emp.email, emp)
  }

}
