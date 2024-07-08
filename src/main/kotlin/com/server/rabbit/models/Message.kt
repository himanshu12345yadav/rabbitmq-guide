package com.server.rabbit.models

import lombok.Data


@Data
data class Message(
    val id: Int,
    val message: String,
    val len: String
)