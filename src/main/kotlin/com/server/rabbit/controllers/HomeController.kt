package com.server.rabbit.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/")
class HomeController {

    @GetMapping("/")
    @ResponseBody
    fun getHomeResponse(): ResponseEntity<String> {
        return ResponseEntity.ok("Server Up and running")
    }

}