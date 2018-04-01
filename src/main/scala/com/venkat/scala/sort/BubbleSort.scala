package com.venkat.scala.sort

class BubbleSort {

  def bubbleSort(a:Array[Double]): Unit = {
    for(i <- 0 until a.length-1){
      for(j <- 0 until a.length-1-i){
        if(a(j) > a(j+1)){
          val tmp = a(j)
          a(j) = a(j+1)
          a(j+1) = tmp
        }
      }
    }
  }

}

object BubbleSort extends App{
  val bubbleSort = new BubbleSort()
  val arrayList = Array.fill(10)(math.random)
  bubbleSort.bubbleSort(arrayList)
  for(i <- 0 until arrayList.length - 1){
    println(arrayList(i))
  }
}
