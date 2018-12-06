package com.venkat.scala.kafka.service

import java.util.Properties
import javax.annotation.PostConstruct

import akka.actor.{ActorSystem, Props}
import com.venkat.scala.kafka.Emp
import com.venkat.scala.kafka.actor.{EmployeeES, EmployeeKafkaConsumer}
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.{StringDeserializer, StringSerializer}
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._

@Service
class EmployeeServcie {

  var bootStrapServer: String = "127.0.0.1:9100"

  var empConsumer: KafkaConsumer[String, String] = _
  val empTopic = "employee-topic"

  @PostConstruct
  def process(): Unit = {
    val properties = getProperties()
    empConsumer = new KafkaConsumer[String, String](properties)
    empConsumer.subscribe(List(empTopic).asJava)

    val actorSystem = ActorSystem("EmpElasticPublisher")

    val employeeES = actorSystem.actorOf(Props(new EmployeeES), name="EmployeeES")
    val empActor = actorSystem.actorOf(Props(new EmployeeKafkaConsumer(empConsumer,employeeES)), name="employeeActor")
    empActor ! Emp
  }

  def getProperties(): Properties = {
    val properties = new Properties()
    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer)
    properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false")
    properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000")
    properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "23000")
    properties.put(ConsumerConfig.GROUP_ID_CONFIG, "my_test")
    properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[StringSerializer])
    properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer])
    properties.put(ProducerConfig.ACKS_CONFIG, "all")
    properties.put(ProducerConfig.BATCH_SIZE_CONFIG, "0")

    return properties
  }

}
