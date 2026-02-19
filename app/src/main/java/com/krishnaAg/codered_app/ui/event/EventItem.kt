package com.krishnaAg.codered_app.ui.event

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.krishnaAg.codered_app.domain.model.Event

@Composable
fun EventItem(event: Event) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = event.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "City: ${event.city}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Volunteers Needed: ${event.volunteersCount}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
