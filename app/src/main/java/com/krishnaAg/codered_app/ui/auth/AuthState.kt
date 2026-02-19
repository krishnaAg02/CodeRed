package com.krishnaAg.codered_app.ui.auth

data class AuthState(
    val isLoading: Boolean = false,
    val isAuthenticated: Boolean = false,
    val userName: String? = null,
    val userEmail: String? = null,
    val role: String? = null,
    val errorMessage: String? = null
)
