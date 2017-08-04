package com.venkat.scala.test

/**
  * Created by venkatram.veerareddy on 8/1/2017.
  */

abstract class Type[-T]{
  def typeName: Unit
}

class SuperType extends Type[AnyVal]{
  override def typeName: Unit = {
    println("SuperType")
  }
}

class SubType extends Type[Int]{
  override def typeName: Unit = {
    println("SubType")
  }
}

class TypeCarer{
  def display(t:Type[Int]): Unit ={
    t.typeName
  }
}

object ContravariantTest extends App{

  val superType = new SuperType
  val subType = new SubType

  val typeCarer = new TypeCarer

  typeCarer.display(subType)
  typeCarer.display(superType)

}
