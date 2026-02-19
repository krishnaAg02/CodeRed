package com.krishnaAg.codered_app.domain.model

data class Volunteer(
    val id: String,
    val userId: String,
    val status: String,        // ACTIVE / INACTIVE
    val engagementScore: Int
)
