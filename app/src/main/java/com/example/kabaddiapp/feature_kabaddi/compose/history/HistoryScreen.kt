package com.example.kabaddiapp.feature_kabaddi.compose.history

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import com.example.kabaddiapp.feature_kabaddi.compose.kabaddi.Teams
import com.example.kabaddiapp.feature_kabaddi.viewmodel.KabaddiViewModel
import com.example.kabaddiapp.feature_kabaddi.viewmodel.KabaddiViewModelFactory


@Composable
fun HistoryScreen(
    navController: NavController,
    factory: KabaddiViewModelFactory,
    modifier: Modifier = Modifier,
    kabaddiViewModel: KabaddiViewModel = viewModel(factory = factory)
){

    Scaffold(
        topBar = {
            TopAppBar(
                title = {  Text(text = " Kabbaddi Counter")}
            )
        }

    ) {


        val historyValue = kabaddiViewModel.historyData.observeAsState(initial = emptyList())


//    History Screen
        val historyList = kabaddiViewModel.history.value

        Column(modifier = Modifier.padding(30.dp)) {
            LazyColumn{

                items(historyValue.value){ history ->

                    History(teamA = history.teamA,  teamB = history.teamB, time = history.time, onClose = { /*TODO*/ })





                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                NavigationButton(navController = navController)

            }

        }





    }





}

@Composable
fun  NavigationButton (
    navController: NavController

){
    Button( onClick = {
        navController.navigate("kabaddi_page"){
            navController.graph.startDestinationRoute?.let { route->
                popUpTo(route){
                    saveState= true
                }

            }
            launchSingleTop=true
        } }) {
        Text(text = "Go Back")
    }
}