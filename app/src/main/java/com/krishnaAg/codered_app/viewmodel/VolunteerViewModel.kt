package com.krishnaAg.codered_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krishnaAg.codered_app.domain.model.Volunteer
import com.krishnaAg.codered_app.ui.volunteer.VolunteerUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VolunteerViewModel : ViewModel() {

    private val _state = MutableStateFlow(VolunteerUiState())
    val state: StateFlow<VolunteerUiState> = _state.asStateFlow()

    init {
        loadVolunteers()
    }

    private fun loadVolunteers() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            // Simulating API call
            val sampleVolunteers = listOf(
                Volunteer("1", "user_1", "ACTIVE", 95),
                Volunteer("2", "user_2", "ACTIVE", 88),
                Volunteer("3", "user_3", "INACTIVE", 45)
            )
            _state.value = _state.value.copy(
                isLoading = false,
                volunteers = sampleVolunteers
            )
        }
    }
}
