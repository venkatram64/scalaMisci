package com.venkat.scala.rpn

import org.junit._
import org.junit.Assert._


/**
  * Created by Venkatram on 8/5/2017.
  */
class TestRPNCalc {

  @Test
  def basicOps: Unit = {
    assertEquals(5, RPNCalc("2 3 +".split(" ")), 0.0)
    assertEquals(6, RPNCalc("2 3 *".split(" ")), 0.0)
    assertEquals(6, RPNCalc("9 3 -".split(" ")), 0.0)
    assertEquals(3, RPNCalc("9 3 /".split(" ")), 0.0)
  }

  @Test
  def twoOps: Unit = {
    assertEquals(25, RPNCalc("2 3 + 5 *".split(" ")), 0.0)
    assertEquals(2, RPNCalc("2 3 * 3 /".split(" ")), 0.0)
    assertEquals(13, RPNCalc("9 3 - 7 +".split(" ")), 0.0)
    assertEquals(0, RPNCalc("9 3 / 3 -".split(" ")), 0.0)
  }

  @Test
  def withVars: Unit = {
    val vars = Map("x" -> 3.0, "y" -> 2.0)
    assertEquals(25, RPNCalc("y x + 5 *".split(" ") ,vars), 0.0)
    assertEquals(2, RPNCalc("y x * x /".split(" ") ,vars), 0.0)
    assertEquals(13, RPNCalc("9 x - 7 +".split(" ") ,vars), 0.0)
    assertEquals(0, RPNCalc("9 x / x -".split(" ") ,vars), 0.0)
  }
}

