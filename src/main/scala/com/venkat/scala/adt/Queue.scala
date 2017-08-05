package com.venkat.scala.adt

/**
  * Created by Venkatram on 8/5/2017.
  */
trait Queue[A] {
  /**
    * Adds an item to the queue
    * @param a
    */
  def enqueue(a: A): Unit

  /**
    * Removes the item that has been on the queue longest. FIFO
    * @return
    */
  def dequeue(): A

  /**
    * Gives back the next item that would be dequeued.
    * @return
    */

  def peek: A

  /**
    * Tells is there any items on the queue to dequeue
    * @return
    */

  def isEmpty: Boolean

}
