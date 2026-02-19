package com.krishnaAg.codered_app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val userId: String,
    val name: String,
    val email: String,
    val role: String, // ADMIN, MANAGER, HR, HELPLINE, VOLUNTEER
    val city: String
)
