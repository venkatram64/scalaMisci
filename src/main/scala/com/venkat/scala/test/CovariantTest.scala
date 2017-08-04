package com.venkat.scala.test

/**
  * Created by venkatram.veerareddy on 8/1/2017.
  */

class Animal[+T](val animal: T)

class Dog
class Puppy extends Dog

class AnimalCarer(val dog: Animal[Dog])

object CovariantTest extends App{

  val puppy = new Puppy
  val dog = new Dog

  val puppyAnimal: Animal[Puppy] = new Animal[Puppy](puppy)

  val dogAnimal: Animal[Dog] = new Animal[Dog](dog)

  val dogCarer = new AnimalCarer(dogAnimal)

  val puppyCarer = new AnimalCarer(puppyAnimal)

  println("Done.")

}
