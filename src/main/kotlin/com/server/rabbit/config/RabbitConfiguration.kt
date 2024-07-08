package com.server.rabbit.config

import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitConfiguration {

    @Value("\${rabbit.queue.default.name}")
    private lateinit var queue: String

    @Value("\${rabbit.queue.json.name}")
    private lateinit var jsonQueue: String

    @Value("\${rabbit.exchange.default.name}")
    private lateinit var exchange: String

    @Value("\${rabbit.exchange.json.name}")
    private lateinit var jsonExchange: String

    @Value("\${rabbit.routing.default.key}")
    private lateinit var routingKey: String

    @Value("\${rabbit.routing.json.key}")
    private lateinit var jsonRoutingKey: String

    @Bean
    fun queue(): Queue {
        return Queue(queue)
    }


    @Bean
    fun jsonQueue(): Queue {
        return Queue(jsonQueue)
    }

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(exchange)
    }

    @Bean
    fun jsonExchange(): TopicExchange {
        return TopicExchange(jsonExchange)
    }

    @Bean
    fun binding(): Binding {
        return BindingBuilder.bind(queue()).to(exchange()).with(routingKey)
    }

    @Bean
    fun jsonBinding(): Binding {
        return BindingBuilder.bind(jsonQueue()).to(jsonExchange()).with(jsonRoutingKey)
    }

    @Bean
    fun converter(): MessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun amqpTemplate(connectionFactory: ConnectionFactory): AmqpTemplate {
        return RabbitTemplate(connectionFactory).apply {
            messageConverter = converter()
        }
    }
}