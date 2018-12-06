package com.venkat.scala.kafka.actor

import akka.actor.Actor
import com.fasterxml.jackson.databind.JsonDeserializer
import com.venkat.scala.kafka.Emp
import org.apache.http.HttpHost
import org.apache.http.entity.StringEntity
import org.apache.http.message.BasicHeader
import org.apache.log4j.Logger
import org.elasticsearch.client.RestClient

import scala.collection.JavaConverters._

class EmployeeES extends Actor{

  val LOGGER: Logger = Logger.getLogger(classOf[EmployeeES])
  val restClient: RestClient = RestClient.builder(new HttpHost("127.0.0.1", 9200)).build()

  override def receive: Receive = {
    case message: String => {
      //val value = JsonDeserializer.
      val ci = "emp_current" + "id"
      val hi = "emp_history"
      val startTime = System.nanoTime()

      restClient.performRequest("POST",
        ci,
        Map[String, String]().asJava,
        new StringEntity(message),
        new BasicHeader("Content-Type", "application/json")
      )

      restClient.performRequest("POST",
        hi,
        Map[String, String]().asJava,
        new StringEntity(message),
        new BasicHeader("Content-Type", "application/json")
      )

      val endTime = System.nanoTime()
      val totalTimeTaken = (endTime - startTime)/1000000
      LOGGER.info("Time taken " + totalTimeTaken)
    }
    case _ => println("Unknown message")
  }

}
