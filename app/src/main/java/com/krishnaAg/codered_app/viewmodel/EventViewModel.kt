package com.krishnaAg.codered_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krishnaAg.codered_app.domain.model.Event
import com.krishnaAg.codered_app.ui.event.EventUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EventViewModel : ViewModel() {

    private val _state = MutableStateFlow(EventUiState())
    val state: StateFlow<EventUiState> = _state.asStateFlow()

    init {
        loadEvents()
    }

    private fun loadEvents() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            // Simulating API call
            val sampleEvents = listOf(
                Event("1", "Blood Donation Camp", "Mumbai", System.currentTimeMillis(), 10),
                Event("2", "Emergency Awareness", "Delhi", System.currentTimeMillis() + 86400000, 5),
                Event("3", "Health Checkup", "Bangalore", System.currentTimeMillis() + 172800000, 15)
            )
            _state.value = _state.value.copy(
                isLoading = false,
                events = sampleEvents
            )
        }
    }
}
