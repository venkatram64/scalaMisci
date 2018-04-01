package com.venkat.scala.sort
/*
4 7 2 9 3 8 1 5
step 1, start with 7, since 7 is greater than 4, list is same
4 7 2 9 3 8 1 5
step 2, start with 2, since 2 is not greater than 7 and 4, so bring 2 to correction location
2 4 7 9 3 8 1 5
step 3, start with 9, since 9 is greater than 7, 4 and 2 , so do no do
2 4 7 9 3 8 1 5
step 4, start with 3, since 3 smaller to push to correct location
2 3 4 7 9 8 1 5
step 5, start with 8
2 3 4 7 8 9 1 5
step 6, start with 1
1 2 3 4 7 8 9 5
step 7, start with 5
1 2 3 4 5 7 8 9
 */

class InsertionSort {

  def insertionSort(a: Array[Double]): Unit = {
    //start with 1 index not zero
    for(i <- 1 until a.length){
      var j = i - 1
      var tmp = a(i)
      while(j >= 0 && tmp < a(j)){
        a(j + 1) = a(j)
        j -= 1
      }
      a(j + 1) = tmp
    }
  }

}

object InsertionSort extends App{
  val insertionSort = new InsertionSort()
  val array = Array.fill(10)(math.random)
  insertionSort.insertionSort(array)
  array.foreach(println)
}