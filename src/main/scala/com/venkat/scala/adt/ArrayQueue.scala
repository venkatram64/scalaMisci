package com.venkat.scala.adt

import scala.reflect.ClassTag

/**
  * Created by Venkatram on 8/5/2017.
  */
class ArrayQueue[A: ClassTag] extends Queue[A]{

  private var data = new Array[A](10)
  private var front = 0
  private var back = 0

  override def enqueue(a: A): Unit = {

    if((back + 1) % data.length == front){
      val tmp = new Array[A](data.length * 2)
      for(i <- 0 until data.length - 1){
        tmp(i) = data((front + i) % data.length)
      }
      front = 0
      back = data.length - 1
      data = tmp
    }
    data(back) = a
    back = (back + 1) % data.length
  }

  override def peek: A = data(front)

  override def dequeue(): A = {
    val ret = data(front)
    /*front += 1
    if(front >= data.length) front = 0*/
    front = (front + 1) % data.length
    ret
  }

  override def isEmpty: Boolean = front == back
}
