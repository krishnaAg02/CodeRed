package com.krishnaAg.codered_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.krishnaAg.codered_app.ui.auth.LoginScreen
import com.krishnaAg.codered_app.ui.dashboard.DashBoardScreen
import com.krishnaAg.codered_app.ui.helpline.CreateRequestScreen
import com.krishnaAg.codered_app.ui.helpline.RequestListScreen
import com.krishnaAg.codered_app.ui.volunteer.VolunteerListScreen
import com.krishnaAg.codered_app.ui.event.EventListScreen
import com.krishnaAg.codered_app.viewmodel.AuthViewModel
import com.krishnaAg.codered_app.viewmodel.EventViewModel
import com.krishnaAg.codered_app.viewmodel.HelplineViewModel
import com.krishnaAg.codered_app.viewmodel.VolunteerViewModel

object Routes {
    const val LOGIN = "login"
    const val DASHBOARD = "dashboard"
    const val CREATE_REQUEST = "create_request"
    const val REQUEST_LIST = "request_list"
    const val VOLUNTEERS = "volunteers"
    const val EVENTS = "events"
}

@Composable
fun AppNavGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    helplineViewModel: HelplineViewModel,
    volunteerViewModel: VolunteerViewModel,
    eventViewModel: EventViewModel
) {

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {

        // 🔐 Login
        composable(Routes.LOGIN) {
            LoginScreen(
                viewModel = authViewModel,
                onLoginSuccess = {
                    navController.navigate(Routes.DASHBOARD) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        // 🧭 Dashboard (role-based UI inside screen)
        composable(Routes.DASHBOARD) {
            DashBoardScreen(navController = navController)
        }

        // ☎️ Helpline – Create Blood Request
        composable(Routes.CREATE_REQUEST) {
            CreateRequestScreen(
                viewModel = helplineViewModel
            )
        }

        // ☎️ Helpline – View Requests
        composable(Routes.REQUEST_LIST) {
            RequestListScreen(
                viewModel = helplineViewModel
            )
        }

        // 👥 Volunteer Management
        composable(Routes.VOLUNTEERS) {
            VolunteerListScreen(
                viewModel = volunteerViewModel
            )
        }

        // 📅 Events & Outreach
        composable(Routes.EVENTS) {
            EventListScreen(
                viewModel = eventViewModel
            )
        }
    }
}

