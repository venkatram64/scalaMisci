package com.venkat.scala.sort
/*
4 7 2 9 3 8 1 5
step 1, 1 is the minium, swap 4 and 1
1 7 2 9 3 8 4 5
step 2, 2 is the minimum, swap 2 and 7
1 2 7 9 3 8 4 5
step 3, 3 is the minimum, swap 3 and 7
1 2 3 9 7 8 4 5
 */

class SelectionSort {

  def minSort(a: Array[Double]): Unit = {
    for(i <- 0 until a.length - 1){
      var min = i
      for(j <- i + 1 until a.length){
        if(a(j) < a(min)) min = j
      }
      //swap
      val tmp = a(i)
      a(i) = a(min)
      a(min) = tmp
    }
  }

}

object SelectionSort extends App{
  val selectionSort = new SelectionSort()
  val array = Array.fill(10)(math.random)
  selectionSort.minSort(array)
  array.foreach(println)
}
