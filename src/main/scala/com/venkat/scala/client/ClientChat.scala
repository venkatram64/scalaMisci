package com.venkat.scala.client

import java.io.{BufferedReader, InputStreamReader, PrintStream}
import java.net.Socket
import io.StdIn._

import com.venkat.scala.server.ServerChat.sock

/**
  * Created by venkatram.veerareddy on 8/1/2017.
  */
object ClientChat extends App{
  val sock = new Socket("localhost",4000)
  println("connected to server socket...")

  val in = new BufferedReader(new InputStreamReader(sock.getInputStream))
  val out = new PrintStream(sock.getOutputStream)
  println("Type something. ")
  val input = readLine
  out.println(input)
  val s = in.readLine()
  println("Server responded: " + s)
  out.println("Got your message.")

}
