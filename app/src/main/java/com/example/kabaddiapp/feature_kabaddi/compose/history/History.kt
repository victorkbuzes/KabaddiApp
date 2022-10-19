package com.example.kabaddiapp.feature_kabaddi.compose.history

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun History(
    teamA: String,
    teamB: String,
    time:String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,

    ) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(border = BorderStroke(0.5.dp, Color.Gray)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Column(modifier = Modifier.padding(10.dp)) {


            Text(text = "TeamA: $teamA", fontSize = 20.sp)

            Text(text = "TeamB: $teamB", fontSize = 20.sp )
            Text(text = "Time: $time", fontSize = 20.sp)




        }




    }

}