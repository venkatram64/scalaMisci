package com.venkat.scala.adt

/**
  * Created by Venkatram on 8/5/2017.
  */
trait Stack[A] {

  /**
    * This adds an element to that stack
    * @param a
    */
  def push(a: A): Unit

  /**
    * Removes an element from the stack. The element that is removed
    * is the one that was most recently added.
    * @return
    */
  def pop(): A

  /**
    * Gives back the next item that would be popped
    * @return
    */

  def peek: A

  /**
    * Tells is there are no items on the stack to pop.
    * @return
    */
  def isEmpty: Boolean
}
