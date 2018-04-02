package com.venkat.scala.misc

class Rational(n: Int, d: Int) {

  require(d != 0,"denominator should not be zero")
  private val g = gcd(n.abs, d.abs)

  val numer = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1)

  def + (that: Rational): Rational = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def - (that: Rational): Rational = new Rational(numer * that.denom - that.numer * denom, denom * that.denom)

  def * (that: Rational): Rational = new Rational(numer * that.numer , denom * that.denom)

  def / (that: Rational): Rational = new Rational(numer * that.denom , denom * that.numer)

  //def max(that: Rational) = if(this < that) that else this


  override def toString: String = numer + "/" + denom

  private def gcd(a: Int, b: Int): Int = if(b == 0) a else  gcd(b, a%b)
}
/*
Implicit definition

kind of a inheritance
enriching existing class functionality
compilar implicitly calls the method

name of the is immeterial
 */
object Conversion {
  implicit def convertIntoRation(x: Int) = new Rational(x)
}


object Rational extends App{

  val r1 = new Rational(3,4)
  val r2 = new Rational(2,5)

  val result = r1 + r2

  println(result)

  import Conversion._
  val r = 2 + r1 //implicit is called

  println(r)

  val r3 = r1 + 6 //implic is called

  println(r3)



}