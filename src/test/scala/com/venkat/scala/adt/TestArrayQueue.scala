package com.venkat.scala.adt

import org.junit._
import org.junit.Assert._

/**
  * Created by Venkatram on 8/5/2017.
  */
class TestArrayQueue {

  private var queue:Queue[Int] = null

  @Before
  def setUp: Unit ={
    queue = new ArrayQueue[Int]()
  }

  @Test
  def emptyOnCreate: Unit = {
    assertTrue(queue.isEmpty)
  }

  @Test
  def nonEmptyOnPush: Unit ={
    queue.enqueue(1)
    assertFalse(queue.isEmpty)
  }

  @Test
  def enqueueDequeue: Unit ={
    queue.enqueue(123)
    assertEquals(123, queue.peek)
    assertEquals(123, queue.dequeue())
  }

  @Test
  def enqueueDequeueEnqueueDequeue: Unit = {
    queue.enqueue(22)
    assertFalse(queue.isEmpty)
    assertEquals(22, queue.peek)
    assertEquals(22, queue.dequeue())
    assertTrue(queue.isEmpty)

    queue.enqueue(11)
    assertFalse(queue.isEmpty)
    assertEquals(11, queue.peek)
    assertEquals(11, queue.dequeue())
    assertTrue(queue.isEmpty)

  }

  @Test
  def enqueueEnqueueDequeueDequeue: Unit = {
    queue.enqueue(11)
    queue.enqueue(22)

    assertEquals(11, queue.peek)
    assertEquals(11, queue.dequeue())
    assertFalse(queue.isEmpty)

    assertFalse(queue.isEmpty)
    assertEquals(22, queue.peek)
    assertEquals(22, queue.dequeue())
    assertTrue(queue.isEmpty)
  }

  @Test
  def enqueueDequeue100: Unit ={
    val nums = Array.fill(100)(util.Random.nextInt())
    nums.foreach(queue.enqueue)
    nums.foreach{ n =>
      //println(n + " " + queue.peek)
      assertEquals(n, queue.peek)
      assertEquals(n, queue.dequeue())
    }
  }

}
