package com.venkat.scala.recursion

class RecrusionEx {

  var pegs:Array[List[Int]] = Array()

  //auxilory constructor
  def this(n: Int){
    this()
    this.pegs = Array((1 to n).toList,Nil, Nil)
    for(p <- pegs) println(p)
  }

  def fib(n: Int): Int = if(n < 2) 1 else fib(n-1) + fib(n -2)

  /*def towerOfHanai(n: Int): Unit = {
    val pegs = Array((1 to n).toList,Nil, Nil)
    for(p <- pegs) println(p)
  }*/

  def moveOneDisk(from: Int, to: Int): Unit = {
    require(pegs(to).isEmpty || pegs(from).head < pegs(to).head)
    pegs(to) ::= pegs(from).head
    pegs(from) = pegs(from).tail
  }

  def moveDisks(from: Int, to: Int, n: Int): Unit = {
    if(n == 1) moveOneDisk(from, to)
    else{
      val other = 3 - from - to
      moveDisks(from, other, n-1)
      moveOneDisk(from, to)
      moveDisks(other, to , n-1)
    }
  }

  //permutations
  def permuation(nums:List[Int], f: List[Int]=>Unit, p:List[Int]): Unit = {
    if(nums.isEmpty){
      f(p)
    }else{
      var before = List[Int]()
      var after = nums//it has taken, so add to before after.tail
      while(after.nonEmpty){
        permuation(before ::: after.tail, f, after.head::p)
        println(nums +" --- beofe and after--- " + p)
        before ::= after.head
        after = after.tail
      }
    }
  }
}

object RecrusionEx extends App {
  val recrusionEx = new RecrusionEx();
  for (i <- 1 to 10){
    println(recrusionEx.fib(i))
  }

  println("Tower of Hanai")
  val towerOfHanai = new RecrusionEx(4);
  towerOfHanai.moveDisks(0,2, 4)
  println("______________")
  for(p <- towerOfHanai.pegs) println(p)

  println("Permutations")
  recrusionEx.permuation(List(1,2,3),println,Nil)
}
