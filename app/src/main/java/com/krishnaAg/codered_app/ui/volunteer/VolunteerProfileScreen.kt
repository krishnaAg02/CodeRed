package com.krishnaAg.codered_app.ui.volunteer

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.krishnaAg.codered_app.ui.Components.AppTopBar
import com.krishnaAg.codered_app.viewmodel.VolunteerViewModel

@Composable
fun VolunteerProfileScreen(
    viewModel: VolunteerViewModel,
    volunteerId: String,
    onBack: (() -> Unit)? = null
) {
    val state by viewModel.state.collectAsState()
    val volunteer = state.volunteers.find { it.id == volunteerId }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Volunteer Profile",
                onBack = onBack
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (volunteer != null) {
                Text(text = "User ID: ${volunteer.userId}", style = MaterialTheme.typography.headlineSmall)
                Text(text = "Status: ${volunteer.status}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Engagement Score: ${volunteer.engagementScore}", style = MaterialTheme.typography.bodyLarge)
            } else {
                Text(text = "Volunteer not found", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
