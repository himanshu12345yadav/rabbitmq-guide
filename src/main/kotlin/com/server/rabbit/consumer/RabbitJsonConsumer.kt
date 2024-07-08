package com.server.rabbit.consumer

import com.server.rabbit.models.Message
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class RabbitJsonConsumer {


    private val logger: Logger = LoggerFactory.getLogger(RabbitJsonConsumer::class.java)

    @RabbitListener(queues = ["\${rabbit.queue.json.name}"])
    fun listen(message: Message) {
        logger.info("Rabbit: JSON message received with $message")
    }

}