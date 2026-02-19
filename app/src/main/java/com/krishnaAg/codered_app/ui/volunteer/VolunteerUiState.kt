package com.krishnaAg.codered_app.ui.volunteer

import com.krishnaAg.codered_app.domain.model.Volunteer

data class VolunteerUiState(
    val isLoading: Boolean = false,
    val volunteers: List<Volunteer> = emptyList(),
    val errorMessage: String? = null
)
