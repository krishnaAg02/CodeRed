package com.krishnaAg.codered_app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blood_requests")
data class BloodRequestEntity(
    @PrimaryKey val requestId: String,
    val bloodGroup: String,
    val city: String,
    val status: String, // PENDING, IN_PROGRESS, COMPLETED
    val createdAt: Long,
    val synced: Boolean = false,
    val assignedVolunteerId: String?
)
