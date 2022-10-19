package com.example.kabaddiapp.feature_kabaddi.compose.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kabaddiapp.feature_kabaddi.compose.history.HistoryScreen
import com.example.kabaddiapp.feature_kabaddi.compose.kabaddi.KabaddiScreen
import com.example.kabaddiapp.feature_kabaddi.viewmodel.KabaddiViewModel
import com.example.kabaddiapp.feature_kabaddi.viewmodel.KabaddiViewModelFactory

@Composable
fun HomeScreen(
    factory: KabaddiViewModelFactory,
    modifier: Modifier = Modifier,
    kabaddiViewModel: KabaddiViewModel = viewModel(factory = factory)

){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "kabaddi_page") {
        composable("kabaddi_page", content = { KabaddiScreen(navController = navController, factory )})
        composable("history_page", content = { HistoryScreen(navController = navController, factory) })
    }
}


