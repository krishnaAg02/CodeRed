package com.krishnaAg.codered_app.ui.volunteer

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.krishnaAg.codered_app.domain.model.Volunteer

@Composable
fun VolunteerItem(volunteer: Volunteer) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "User ID: ${volunteer.userId}", style = MaterialTheme.typography.titleMedium)
            Text(text = "Status: ${volunteer.status}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Engagement Score: ${volunteer.engagementScore}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
