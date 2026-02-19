package com.krishnaAg.codered_app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EventEntity(
    @PrimaryKey val eventId: String,
    val name: String,
    val city: String,
    val date: Long,
    val volunteersCount: Int
)
