package com.server.rabbit.controllers

import com.server.rabbit.models.Message
import com.server.rabbit.producer.RabbitJsonProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RabbitJsonController {

    @Autowired
    private lateinit var producer: RabbitJsonProducer

    @PostMapping("message")
    fun sendJsonMessage(@RequestBody message: Message): ResponseEntity<String> {
        producer.sendJsonMessage(message)
        return ResponseEntity.ok("Message sent to json queue")
    }


}