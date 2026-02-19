package com.krishnaAg.codered_app.ui.event

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.krishnaAg.codered_app.ui.Components.AppTopBar
import com.krishnaAg.codered_app.ui.Components.PrimaryButton
import com.krishnaAg.codered_app.viewmodel.EventViewModel

@Composable
fun CreativeEventScreen(
    viewModel: EventViewModel,
    onBack: (() -> Unit)? = null
) {
    var eventName by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Create Event",
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
            OutlinedTextField(
                value = eventName,
                onValueChange = { eventName = it },
                label = { Text("Event Name") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                label = { Text("City") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1f))
            PrimaryButton(
                text = "Create Event",
                onClick = { /* Handle create */ },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
