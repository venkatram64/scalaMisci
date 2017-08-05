package com.venkat.scala.adt

import scala.reflect.ClassTag

/**
  * Created by Venkatram on 8/5/2017.
  */
class ArrayStack[A: ClassTag] extends Stack[A]{

  private var data = new Array[A](10)
  private var top = 0

  override def push(a: A): Unit = {

    if(top >= data.length){
      val tmp = new Array[A](data.length * 2)
      Array.copy(data,0,tmp,0,data.length)
      data = tmp
    }
    data(top) = a
    top += 1
  }

  override def peek: A = data(top - 1)

  override def isEmpty: Boolean = top == 0

  override def pop(): A = {
    top -= 1
    data(top)
  }
}
