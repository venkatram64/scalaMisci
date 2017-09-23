package com.venkat.scala.adt

/**
  * Created by Venkatram on 8/5/2017.
  */

trait ListADT[A] {

  /*def get(index: Int): A
  def set(index: Int, data: A): Unit*/
  def apply(index: Int): A
  def update(index: Int, data: A): Unit
  def insert(index: Int, data: A): Unit
  def remove(index: Int): A

}
