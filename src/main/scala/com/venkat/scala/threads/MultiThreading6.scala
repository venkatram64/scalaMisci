package com.venkat.scala.threads

/**
  * Created by venkatram.veerareddy on 8/2/2017.
  */
/*
  parallel processing
  concurrency
 */
object MultiThreading6{

  def main(args:Array[String]): Unit = {
    simpleCollisions
  }
  case class Particle(x:Double, y:Double, vx:Double, vy:Double, radius:Double){
    def quadrant: Int = {
      (if(x > 0) 1 else 0) + (if(y > 0) 2 else 0)  //4 quadrants
    }
  }

  val dt = 0.001

  def simpleCollisions: Unit ={
    val particles = Array.fill(1000)(Particle(math.random - 0.5, math.random - 0.5,
      math.random - 0.5, math.random - 0.5, 0.01))

    val groups = particles.groupBy((_.quadrant))
    var completeCount = 0
    var stillFinding = true
    val threads = for(i <- 0 to 3) yield{ // 4 quadrants
      new Thread(new Runnable {
        override def run(): Unit = {
          val parts = groups(i)
          for(step <- 1 to 10){
            //check for collisions
            val overlapIndices = findOverlaps(parts)
            MultiThreading6.synchronized {
              if (completeCount < 3) {
                completeCount += 1
                while(stillFinding) MultiThreading6.wait()
              } else {
                stillFinding = false
                MultiThreading6.notifyAll()
                completeCount = 0
              }
            }
            //handle overlaps
            handleOverlaps(parts,overlapIndices)
            MultiThreading6.synchronized {
              if (completeCount < 3) {
                completeCount += 1
                MultiThreading6.wait()
              } else {
                MultiThreading6.notifyAll()
                completeCount = 0
              }
            }
            //advance the particles
            advanceParticles(parts)
            MultiThreading6.synchronized {
              if (completeCount < 3) {
                completeCount += 1
                MultiThreading6.wait()
              } else {
                MultiThreading6.notifyAll()
                completeCount = 0
              }
            }
            //exchange particles
          }
        }
      })
    }
    threads.foreach(_.start())
  }

  def findOverlaps(parts:Array[Particle]): List[(Int, Int)] = {
    //TODO
    Nil
  }

  def handleOverlaps(parts:Array[Particle], overlaps:List[(Int,Int)]): Unit = {
    //TODO
  }

  def advanceParticles(parts:Array[Particle]): Unit = {
    for(i <- parts.indices){
      parts(i) = parts(i).copy(x = parts(i).x + dt * parts(i).vx, y = parts(i).y + dt * parts(i).vy)
    }

  }

}

/*
  Deadlock

  Thread 1
    A.synchronized{
      '''''
      B.synchronized{
        '''''
      }
      '''''
    }

  Thread 2
    B.synchronized{
      '''''
      A.synchronized{
        '''''
      }
      '''''
    }
 */
