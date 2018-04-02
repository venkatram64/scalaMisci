package com.venkat.scala.sort


class MergeSort2 {

  def merge(a: List[Int], b: List[Int]) : List[Int] = (a,b) match {
    case (Nil, _) => b
    case (_, Nil) => a
    case (x::xs, y::ys) =>
      if(x <= y) x :: merge(xs, b)
      else y :: merge(a, ys)
  }

  def mergeSort(lst: List[Int]): List[Int] = {
    if(lst.length < 2) lst
    else {
      val (first, second) = lst.splitAt(lst.length/2)
      merge(mergeSort(first), mergeSort(second))
    }
  }

}

object MergeSort2 extends App{

  val mergeSort = new MergeSort2()
  val nums = List.fill(10)(util.Random.nextInt(100))
  val sortedList = mergeSort.mergeSort(nums)
  sortedList.foreach(println)

}
