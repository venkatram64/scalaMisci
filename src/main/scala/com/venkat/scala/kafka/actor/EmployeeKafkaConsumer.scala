package com.venkat.scala.kafka.actor

import akka.actor.{Actor, ActorRef}
import com.venkat.scala.kafka.Emp
import org.apache.kafka.clients.consumer.KafkaConsumer

class EmployeeKafkaConsumer(kafkaConsumer: KafkaConsumer[String, String], emp: ActorRef) extends Actor{

  override def receive: Receive = {
    case Emp => {
      while(true) {
        println("Reading Emp records...")
        val records = kafkaConsumer.poll(500)
        records.forEach( rec => {
          emp !rec.value()
        })
      }
    }
  }

}
