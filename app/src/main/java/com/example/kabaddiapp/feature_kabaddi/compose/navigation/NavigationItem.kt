package com.example.kabaddiapp.feature_kabaddi.compose.navigation

import com.example.kabaddiapp.R


sealed class NavigationItem(var route:String,var Icon:Int,var title:String)
{
    object  Kabaddi: NavigationItem("kabaddi_page", R.drawable.ic_launcher_background,"Kabadi")
    object  History: NavigationItem("history_page", R.drawable.ic_launcher_background,"History")
}
