package com.venkat.scala.cc

/**
  * Created by venkatram.veerareddy on 8/1/2017.
  */

case class Point3D(x:Double, y:Double, z:Double)

case class Student(name:String, tests:List[Int], assns:List[Int], quizzes:List[Int])

object Point3dTest extends App{

  def classAvg(s: Student): Double = {
    0.4*s.tests.sum/s.tests.length + 0.5*s.assns.sum/s.assns.length + 0.1 * s.quizzes.sum/s.quizzes.length
  }

  def mag(p: Point3D) : Double = {
    Math.sqrt(p.x*p.x + p.y * p.y + p.z * p.z)
  }

  val p = Point3D(1,2,3)
  println(mag(p))

  val s = Student("Venkatram",List(90,88),List(100,95),List(98,84,72))
  println(classAvg(s))

}
