package com.krishnaAg.codered_app.domain.model

data class BloodRequest(
    val id: String,
    val bloodGroup: String,
    val city: String,
    val status: String,    // PENDING, IN_PROGRESS, COMPLETED
    val assignedVolunteerId: String? = null
)

