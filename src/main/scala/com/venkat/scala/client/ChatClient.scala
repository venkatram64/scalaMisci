package com.venkat.scala.client

import java.io.{BufferedReader, InputStreamReader, PrintStream}
import java.net.Socket

import io.StdIn._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


/**
  * Created by venkatram.veerareddy on 8/1/2017.
  */
object ChatClient extends App{

  val sock = new Socket("localhost",4000)
  println("connected to server socket...")

  val in = new BufferedReader(new InputStreamReader(sock.getInputStream))
  val out = new PrintStream(sock.getOutputStream)

  Future {
    while (true) {
      val p = in.readLine()
      if(p != null) println(p)
    }
  }

  var input = ""
  while(input != ":quit") {
    val input = readLine()
    out.println(input)
  }
  sock.close()
}
