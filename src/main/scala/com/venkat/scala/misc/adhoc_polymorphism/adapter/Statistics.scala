package com.venkat.scala.misc.adhoc_polymorphism.adapter


object Statistics {

  trait NumberLike[A] {
    def get: A

    def plus(y: NumberLike[A]): NumberLike[A]

    def minus(y: NumberLike[A]): NumberLike[A]

    def divide(y: Int): NumberLike[A]
  }

  case class NumberLikeDouble(x: Double) extends NumberLike[Double] {

    def get: Double = x

    override def plus(y: NumberLike[Double]): NumberLike[Double] = NumberLikeDouble(x + y.get)

    override def minus(y: NumberLike[Double]) = NumberLikeDouble(x - y.get)

    override def divide(y: Int): NumberLike[Double] = NumberLikeDouble(x / y)

  }

  case class NumberLikeInt(x: Double) extends NumberLike[Double] {

    def get: Double = x

    override def plus(y: NumberLike[Double]): NumberLike[Double] = NumberLikeInt(x + y.get)

    override def minus(y: NumberLike[Double]) = NumberLikeInt(x - y.get)

    override def divide(y: Int): NumberLike[Double] = NumberLikeInt(x / y)

  }

  def median[A](xs: Vector[NumberLike[A]]): NumberLike[A] = xs(xs.size/2)

  def mean[A](xs: Vector[NumberLike[A]]): NumberLike[A] =
                                              xs.reduce(_.plus((_)).divide(xs.size))

}

