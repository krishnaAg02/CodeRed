package com.krishnaAg.codered_app.domain.model

data class Event(
    val id: String,
    val name: String,
    val city: String,
    val date: Long,
    val volunteersCount: Int
)
