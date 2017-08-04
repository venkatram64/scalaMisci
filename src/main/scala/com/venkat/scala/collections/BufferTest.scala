package com.venkat.scala.collections

import collection.mutable

/**
  * Created by venkatram.veerareddy on 8/2/2017.
  */
object BufferTest extends App{

  val buffer = mutable.Buffer(5,6,7)
  //buffer.foreach(println)
  buffer += 2

  //buffer.foreach(println)

  12 +=: buffer  //prepend

  buffer. +=: (15) //prepend

  buffer.foreach(println)

  buffer.remove(0)

  buffer.insert(3, 16)
  buffer.foreach(println)
  buffer.insertAll(3, List(8,9,5))

  buffer.foreach(println)

}
