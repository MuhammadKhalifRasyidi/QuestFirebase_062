package com.example.meet14.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.meet14.ui.view.DetailScreen
import com.example.meet14.ui.view.HomeScreen
import com.example.meet14.ui.view.InsertMhsView

@Composable
fun PengelolaHalaman(
    modifier: Modifier,
    navController: NavHostController =  rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiInsert.route)
                },
            )
        }
        composable(DestinasiInsert.route) {
            InsertMhsView(
                onBack = { navController.popBackStack() },
                onNavigate = {
                    navController.navigate(DestinasiHome.route)
                }
            )
        }
        composable(
            DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.NIM) {
                type = NavType.StringType
            })) {
            val nim = it.arguments?.getString(DestinasiDetail.NIM)
            nim?.let { nim ->
                DetailScreen(onBackClick = {
                    navController.popBackStack()
                }, onEditClick = {
                    navController.navigate("${DestinasiHome.route}/$it")
                }, nim = nim
                )
            }
        }
    }
}
