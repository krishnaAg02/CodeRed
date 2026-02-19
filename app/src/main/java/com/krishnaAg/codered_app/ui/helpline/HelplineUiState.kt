package com.krishnaAg.codered_app.ui.helpline

import com.krishnaAg.codered_app.domain.model.BloodRequest

data class HelplineUiState(
    val isLoading: Boolean = false,
    val bloodRequests: List<BloodRequest> = emptyList(),
    val errorMessage: String? = null
)
