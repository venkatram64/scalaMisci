package com.venkat.scala.misc.adhoc_polymorphism.typeclasses

import Math.NumberLike

object Statistics {

  def mean[T](xs: Vector[T])(implicit ev: NumberLike[T]): T =
                                          ev.divide(xs.reduce(ev.plus(_,_)),xs.size)

  def median[T](xs: Vector[T])(implicit ev: NumberLike[T]): T =
                                          xs(xs.size/2)

}
