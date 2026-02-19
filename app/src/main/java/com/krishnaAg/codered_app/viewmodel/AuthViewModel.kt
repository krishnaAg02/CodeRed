package com.krishnaAg.codered_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krishnaAg.codered_app.ui.auth.AuthState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state.asStateFlow()

    val currentUserRole: String?
        get() = _state.value.role

    fun onGoogleSignInStarted() {
        _state.value = _state.value.copy(
            isLoading = true,
            errorMessage = null
        )
    }

    fun onGoogleSignInSuccess(
        displayName: String?,
        email: String?
    ) {
        _state.value = AuthState(
            isLoading = false,
            isAuthenticated = true,
            userName = displayName ?: email ?: "User",
            userEmail = email,
            role = "ADMIN", // default role for now
            errorMessage = null
        )
    }

    fun onGoogleSignInError(message: String?) {
        _state.value = _state.value.copy(
            isLoading = false,
            isAuthenticated = false,
            errorMessage = message ?: "Unable to sign in with Google"
        )
    }

    fun logout() {
        viewModelScope.launch {
            _state.value = AuthState()
        }
    }
}
