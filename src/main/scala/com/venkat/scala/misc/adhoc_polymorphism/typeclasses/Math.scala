package com.venkat.scala.misc.adhoc_polymorphism.typeclasses


object Math {

  trait NumberLike[T]{
    def plus(x: T, y: T): T
    def divide(x: T, y: Int): T
    def minus(x: T, y: T): T
  }

  object NumberLike{

    implicit object NumberLikeDouble extends NumberLike[Double]{
      def plus(x: Double, y: Double): Double = x + y
      def divide(x: Double, y: Int): Double = x/y
      def minus(x: Double, y: Double): Double = x - y
    }

    implicit object NumberLikeInt extends NumberLike[Int]{
      def plus(x: Int, y: Int): Int = x + y
      def divide(x: Int, y: Int): Int = x/y
      def minus(x: Int, y: Int): Int = x - y
    }
  }

}
