package com.venkat.scala.sort

class QuickSort2 {

  def quickSort(lst: List[Int]): List[Int] = lst match{
    case Nil => Nil
    case x::Nil => lst
    case _ =>
      val p = lst.head //take p as head element
      val (before, after) = lst.tail.partition(_ < p) //partition the tail elements into less and greater
      quickSort(before) ++ (p :: quickSort(after))
  }

}

object QuickSort2 extends App{

  val quickSort2 = new QuickSort2()
  val lst = List.fill(10)(util.Random.nextInt(100))
  println("un sorted list")
  lst.foreach(println)
  println("sorted list")
  val sortedList = quickSort2.quickSort(lst)
  sortedList.foreach(println)

}
