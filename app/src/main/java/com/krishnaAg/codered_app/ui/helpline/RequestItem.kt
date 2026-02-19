package com.krishnaAg.codered_app.ui.helpline

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.krishnaAg.codered_app.domain.model.BloodRequest

@Composable
fun RequestItem(request: BloodRequest) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Blood Group: ${request.bloodGroup}", style = MaterialTheme.typography.titleMedium)
            Text(text = "City: ${request.city}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Status: ${request.status}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
