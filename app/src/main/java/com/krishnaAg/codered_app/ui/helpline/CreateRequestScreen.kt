package com.krishnaAg.codered_app.ui.helpline

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.krishnaAg.codered_app.ui.Components.AppTopBar
import com.krishnaAg.codered_app.ui.Components.PrimaryButton
import com.krishnaAg.codered_app.viewmodel.HelplineViewModel

@Composable
fun CreateRequestScreen(
    viewModel: HelplineViewModel,
    onBack: (() -> Unit)? = null
) {
    var bloodGroup by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Create Request",
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
                value = bloodGroup,
                onValueChange = { bloodGroup = it },
                label = { Text("Blood Group") },
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
                text = "Submit Request",
                onClick = { /* Handle submit */ },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
