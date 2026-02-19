package com.krishnaAg.codered_app.domain.model

data class Donor(
    val id: String,
    val name: String,
    val bloodGroup: String,
    val city: String,
    val lastDonationDate: Long,
    val available: Boolean
)
