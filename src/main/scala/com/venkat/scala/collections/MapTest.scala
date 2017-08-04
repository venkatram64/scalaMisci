package com.venkat.scala.collections

/**
  * Created by venkatram.veerareddy on 8/2/2017.
  */

case class Student(name:String, grade:Int)

object MapTest extends App{

  val map = Map(("one",1),("two",2),("three",3))

  map.foreach(println)

  val map2 = Map("four" -> 4,"five" -> 5, "six" -> 6)

  map2.foreach(println)

  val students = Seq(Student("Venkatram",98),Student("Srijan",99),Student("Vinny",100))
  val stuMap = Map(students.map(s => s.name -> s):_*) //converting into map
  val stuMap2 = students.map(s => s.name -> s).toMap  //converting into map
  stuMap.foreach(println)
}
