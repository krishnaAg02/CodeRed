package com.krishnaAg.codered_app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VolunteerEntity(
    @PrimaryKey val volunteerId: String,
    val userId: String,
    val status: String, // Active / Inactive
    val engagementScore: Int
)
