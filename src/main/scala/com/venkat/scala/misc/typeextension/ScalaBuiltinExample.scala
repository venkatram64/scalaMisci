package com.venkat.scala.misc.typeextension

import java.util


object ScalaBuiltinExample extends App{

  val javaList = new util.ArrayList[Int]()
  javaList.add(10)
  javaList.add(20)
  javaList.add(30)

  import scala.collection.JavaConversions._

  println(javaList.sum)

  import scala.collection.JavaConverters._

  println(javaList.asScala.sum)

}
