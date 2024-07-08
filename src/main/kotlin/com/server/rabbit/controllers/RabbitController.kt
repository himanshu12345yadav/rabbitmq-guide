package com.server.rabbit.controllers

import com.server.rabbit.producer.RabbitProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RabbitController {

    @Autowired
    private lateinit var producer: RabbitProducer

    @GetMapping("/message")
    fun getMessage(@RequestParam("title") message: String): ResponseEntity<String> {
        producer.sendMessage(message)
        return ResponseEntity.ok("Message send to default queue");
    }

}