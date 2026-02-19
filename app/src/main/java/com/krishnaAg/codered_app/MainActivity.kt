package com.krishnaAg.codered_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.krishnaAg.codered_app.navigation.AppNavGraph
import com.krishnaAg.codered_app.ui.theme.CodeRedAppTheme
import com.krishnaAg.codered_app.viewmodel.AuthViewModel
import com.krishnaAg.codered_app.viewmodel.EventViewModel
import com.krishnaAg.codered_app.viewmodel.HelplineViewModel
import com.krishnaAg.codered_app.viewmodel.VolunteerViewModel

class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModels()
    private val helplineViewModel: HelplineViewModel by viewModels()
    private val volunteerViewModel: VolunteerViewModel by viewModels()
    private val eventViewModel: EventViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeRedAppTheme {
                val navController = rememberNavController()
                Surface(color = Color.Transparent) {
                    AppNavGraph(
                        navController = navController,
                        authViewModel = authViewModel,
                        helplineViewModel = helplineViewModel,
                        volunteerViewModel = volunteerViewModel,
                        eventViewModel = eventViewModel
                    )
                }
            }
        }
    }
}

