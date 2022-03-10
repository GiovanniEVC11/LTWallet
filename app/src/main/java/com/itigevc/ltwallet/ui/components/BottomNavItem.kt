package com.itigevc.ltwallet.ui.components
/*
import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.itigevc.ltwallet.ui.util.Screens

enum class BottomNavItem(
    val icon : ImageVector,
    val route : Screens
) {
    FEED(Icons.Default.Home, Screens.Feed.route),
    SEARCH(Icons.Default.Search, Screens.Search.route),
    PROFILE(Icons.Default.Person, Screens.Profile.route)
}

@Composable
fun BottomNavMenu(
    selectedItem : BottomNavItem,
    navController: NavController
){

    Row( modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
    ){

        for( item in BottomNavMenu.values() ){

            Image(
                imageVector = item.icon,
                contentDescription = "Image",
                modifier = Modifier.size(40.dp)
                    .weight(1f).padding(5.dp).clickable{  },
                colorFilter = if(item == selectedItem) ColorFilter.tint(Color.Black)
                    else ColorFilter.tint(Color.Gray)
            )

        }

    }

}


 */