package com.venkat.scala.server

import java.io.{BufferedReader, InputStreamReader, PrintStream}
import java.net.ServerSocket

import io.StdIn._

/**
  * Created by venkatram.veerareddy on 8/1/2017.
  */


object ServerChat extends App{

  val ss = new ServerSocket(4000)
  println("Accepting...")
  val sock = ss.accept()
  println("Got socket " + sock)

  val in = new BufferedReader(new InputStreamReader(sock.getInputStream))
  val out = new PrintStream(sock.getOutputStream)

  val s = in.readLine()
  println("The client said: " + s)
  out.println("Got your message. ")
}
