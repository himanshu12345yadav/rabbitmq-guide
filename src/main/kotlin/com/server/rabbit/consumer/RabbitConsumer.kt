package com.server.rabbit.consumer

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class RabbitConsumer {


    private val logger: Logger = LoggerFactory.getLogger(RabbitConsumer::class.java)


    @RabbitListener(queues = ["\${rabbit.queue.default.name}"])
    fun listen(message: String) {
        logger.info("Rabbit: Message received from rabbit-server $message")
    }
}