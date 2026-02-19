package com.krishnaAg.codered_app.ui.volunteer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.krishnaAg.codered_app.ui.Components.AppTopBar
import com.krishnaAg.codered_app.ui.Components.LoadingView
import com.krishnaAg.codered_app.viewmodel.VolunteerViewModel

@Composable
fun VolunteerListScreen(
    viewModel: VolunteerViewModel,
    onBack: (() -> Unit)? = null
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Volunteers",
                onBack = onBack
            )
        }
    ) { paddingValues ->
        if (state.isLoading) {
            LoadingView()
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(state.volunteers) { volunteer ->
                    VolunteerItem(volunteer)
                }
            }
        }
    }
}
