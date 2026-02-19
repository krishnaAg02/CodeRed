package com.krishnaAg.codered_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krishnaAg.codered_app.domain.model.BloodRequest
import com.krishnaAg.codered_app.ui.helpline.HelplineUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HelplineViewModel : ViewModel() {

    private val _state = MutableStateFlow(HelplineUiState())
    val state: StateFlow<HelplineUiState> = _state.asStateFlow()

    init {
        loadBloodRequests()
    }

    private fun loadBloodRequests() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            // Simulating API call
            val sampleRequests = listOf(
                BloodRequest("1", "O+", "Mumbai", "PENDING"),
                BloodRequest("2", "A-", "Delhi", "IN_PROGRESS"),
                BloodRequest("3", "B+", "Bangalore", "COMPLETED")
            )
            _state.value = _state.value.copy(
                isLoading = false,
                bloodRequests = sampleRequests
            )
        }
    }
}
