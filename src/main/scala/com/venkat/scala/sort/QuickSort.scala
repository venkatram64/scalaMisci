package com.venkat.scala.sort
// ::: => concatinates
class QuickSort {
  //o(n long n)
  def quickSork(lst: List[Double]): List[Double] = lst match {
    case Nil => lst //if list is having nothing
    case h::Nil => lst //if list is having only one element
    case pivot::t => //take the first element as the pivot, remaing is the tatil
      val (less, greater) = t.partition(_ < pivot)  //divide two lists into greater than pivot and less than pivor
      quickSork(less) ::: (pivot :: quickSork(greater))
  }

}

object QuickSort extends App{
  val quickSort1 = new QuickSort();
  val list = quickSort1.quickSork(List.fill(10)(math.random))
  list.foreach(println)
}
