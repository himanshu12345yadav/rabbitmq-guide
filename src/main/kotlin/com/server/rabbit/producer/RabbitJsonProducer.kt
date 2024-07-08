package com.server.rabbit.producer

import com.server.rabbit.models.Message
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service


@Service
class RabbitJsonProducer(val rabbitTemplate: RabbitTemplate) {

    private val logger: Logger = LoggerFactory.getLogger(RabbitJsonProducer::class.java)


    @Value("\${rabbit.routing.json.key}")
    private lateinit var routing: String

    @Value("\${rabbit.exchange.json.name}")
    private lateinit var exchange: String

    fun sendJsonMessage(message: Message) {
        logger.info("Rabbit: Message send to rabbit-server $message")
        rabbitTemplate.convertAndSend(exchange, routing, message);
    }

}