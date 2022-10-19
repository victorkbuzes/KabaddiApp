package com.example.kabaddiapp.feature_kabaddi.compose.kabaddi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kabaddiapp.feature_kabaddi.viewmodel.KabaddiViewModel
import com.example.kabaddiapp.feature_kabaddi.viewmodel.KabaddiViewModelFactory
import com.example.kabaddiapp.feature_kabaddi.compose.utils.getCurrentDate


@Composable
fun KabaddiScreen(
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




        LazyColumn{
            item {
                Teams(kabaddiViewModel, navController = navController)


            }


        }



    }



}

@Composable
fun Teams(viewModel: KabaddiViewModel, navController: NavController){
    Column (modifier = Modifier.padding(20.dp)){
        Row(modifier = Modifier.fillMaxWidth() ) {

            TeamA(viewModel = viewModel)
            Divider(color = Color.Red, modifier = Modifier
                .fillMaxHeight()
                .width(1.dp))
            Spacer(Modifier.width(15.0.dp))
            TeamB(viewModel= viewModel)




        }
        Spacer(Modifier.height(30.dp))


        ResetButton(viewModel = viewModel)
        
        NavigationButton(navController = navController)


    }

}



@Composable
fun TeamB( modifier: Modifier = Modifier , viewModel: KabaddiViewModel){

    Column (){
        Text(text = "Team B", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "${viewModel.counterB.value}", style = MaterialTheme.typography.h4)
        CalculationButton(symbol = "+1") {
            viewModel.incrementTeamBby1()
            viewModel.addResult(teamA = viewModel.counterA.value.toString(), teamB = viewModel.counterB.value.toString(), time = getCurrentDate())

        }


        Spacer(modifier = Modifier.height(20.dp))
        CalculationButton(symbol = "+2") {
            viewModel.incrementTeamBby2()
            viewModel.addResult(teamA = viewModel.counterA.value.toString(), teamB = viewModel.counterB.value.toString(), time = getCurrentDate())

        }

    }

}

@Composable
fun TeamA( modifier: Modifier = Modifier, viewModel: KabaddiViewModel){

    Column (){
        Text(text = "Team A", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "${viewModel.counterA.value}", style = MaterialTheme.typography.h4)

        CalculationButton(symbol = "+1") {
            viewModel.incrementTeamABy1()
            viewModel.addResult(teamA = viewModel.counterA.value.toString(), teamB = viewModel.counterB.value.toString(), time = getCurrentDate())

        }

        Spacer(modifier = Modifier.height(20.dp))

        CalculationButton(symbol = "+2"){
            viewModel.incrementTeamAby2()
            viewModel.addResult(teamA = viewModel.counterA.value.toString(), teamB = viewModel.counterB.value.toString(), time = getCurrentDate())
        }


    }


}
@Composable
fun  ResetButton(viewModel: KabaddiViewModel){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(50.dp),


    ) {
        CalculationButton(symbol = "Reset") {
            viewModel.resetCounter()
            viewModel.removeResult()

        }

    }


}




@Composable
fun CalculationButton(
    symbol: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Blue,
    textStyle: TextStyle = TextStyle(),
    onClick: () -> Unit
){
    Box(
        contentAlignment = Alignment.Center,

        modifier = Modifier
            .background(color)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
                onClick()
            }
            .then(modifier),
        
    ) {
        Text(text = symbol, style = textStyle, color = Color.White)

    }

}

@Composable
fun  NavigationButton (
    navController: NavController

){
    Button(onClick = {
    navController.navigate("history_page"){
        navController.graph.startDestinationRoute?.let { route->
            popUpTo(route){
                saveState= true
            }

        }
        launchSingleTop=true
    } }) {
    Text(text = "View History")
}
}


