package com.krishnaAg.codered_app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DonorEntity(
    @PrimaryKey val donorId: String,
    val name: String,
    val bloodGroup: String,
    val city: String,
    val lastDonationDate: Long,
    val available: Boolean
)
