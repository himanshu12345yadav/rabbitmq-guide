package com.server.rabbit.producer

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service


@Service
class RabbitProducer(val rabbitTemplate: RabbitTemplate) {

    private val logger: Logger = LoggerFactory.getLogger(RabbitProducer::class.java);

    @Value("\${rabbit.exchange.default.name}")
    private lateinit var exchange: String

    @Value("\${rabbit.routing.default.key}")
    private lateinit var routing: String

    fun sendMessage(message: String) {
        logger.info(String.format("Rabbit: Message send to Rabbitmq : $message"));
        return rabbitTemplate.convertAndSend(exchange, routing, message)
    }


}