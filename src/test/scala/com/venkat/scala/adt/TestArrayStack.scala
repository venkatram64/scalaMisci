package com.venkat.scala.adt

import org.junit._
import org.junit.Assert._

/**
  * Created by Venkatram on 8/5/2017.
  */
class TestArrayStack {

  private var stack:Stack[Int] = null

  @Before
  def setUp: Unit ={
    stack = new ArrayStack[Int]()
  }

  @Test
  def emptyOnCreate: Unit = {
    assertTrue(stack.isEmpty)
  }

  @Test
  def nonEmptyOnPush: Unit ={
    stack.push(1)
    assertFalse(stack.isEmpty)
  }

  @Test
  def pushPop: Unit ={
    stack.push(123)
    assertEquals(123, stack.peek)
    assertEquals(123, stack.pop)
  }

  @Test
  def pushPopPushPop: Unit = {
    stack.push(22)
    assertFalse(stack.isEmpty)
    assertEquals(22, stack.peek)
    assertEquals(22, stack.pop)
    assertTrue(stack.isEmpty)

    stack.push(11)
    assertFalse(stack.isEmpty)
    assertEquals(11, stack.peek)
    assertEquals(11, stack.pop)
    assertTrue(stack.isEmpty)

  }

  @Test
  def pushPushPopPop: Unit = {
    stack.push(11)
    stack.push(22)

    assertFalse(stack.isEmpty)
    assertEquals(22, stack.peek)
    assertEquals(22, stack.pop)
    assertFalse(stack.isEmpty)

    assertEquals(11, stack.peek)
    assertEquals(11, stack.pop)
    assertTrue(stack.isEmpty)

  }

  @Test
  def pushPop100: Unit ={
    val nums = Array.fill(100)(util.Random.nextInt())
    nums.foreach(stack.push)
    nums.reverse.foreach{ n =>
      assertEquals(n, stack.peek)
      assertEquals(n, stack.pop)
    }
  }

}
