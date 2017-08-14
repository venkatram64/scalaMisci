package com.venkat.scala.misc.implicitly

import com.venkat.scala.misc.implicitly.Math.NumberLike


object Statistics {


  def main[T: NumberLike](xs: Vector[T]): T = {
    val implicitValue = implicitly[NumberLike[T]]
    implicitValue.divide(xs.reduce(implicitValue.plus(_,_)), xs.size)
  }

  def median[T: NumberLike](xs: Vector[T]): T = xs(xs.size / 2)

  def change[T: NumberLike](xs: Vector[T]): T = {
    val implicitValue = implicitly[NumberLike[T]]
    val maxValue = xs.reduce((a, b) => implicitValue.max(a, b))
    val minValue = xs.reduce((a, b) => implicitValue.min(a, b))
    implicitValue.minus(maxValue, minValue)
  }

}
