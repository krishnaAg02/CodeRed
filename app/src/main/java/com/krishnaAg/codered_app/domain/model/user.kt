package com.krishnaAg.codered_app.domain.model

data class user(
    val id: String,
    val name: String,
    val email: String,
    val role: String,   // ADMIN, MANAGER, HR, HELPLINE, VOLUNTEER
    val city: String
)
