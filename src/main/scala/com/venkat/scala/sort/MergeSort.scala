package com.venkat.scala.sort

import scala.annotation.tailrec

class MergeSort {
//o(n log n)
  def mergeSort(lst: List[Double]): List[Double] = lst match {
    case Nil => lst //this case empty list
    case h::Nil => lst //this case list having only one element
    case _ =>
      val (l1, l2) = lst.splitAt(lst.length/2)
      merge(mergeSort(l1), mergeSort(l2), Nil)
  }

  @tailrec
  private def merge(l1: List[Double], l2:List[Double], lst:List[Double]): List[Double] = (l1, l2) match {
    case (Nil, _) => lst.reverse ::: l2
    case (_, Nil) => lst.reverse ::: l1
    case (h1::t1, h2::t2) => //from list one element is h1, remaining elements are t1
      if(h1 < h2) merge(t1, t2, h1::lst)
      else merge(l1, t2, h2::lst)
  }

}

object  MergeSort extends App{
  val mergeSort = new MergeSort()
  val list = mergeSort.mergeSort(List.fill(20000)(Math.random))
  list.foreach(println)
}
