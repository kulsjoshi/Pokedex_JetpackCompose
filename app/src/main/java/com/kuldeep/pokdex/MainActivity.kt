package com.kuldeep.pokdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kuldeep.pokdex.ui.theme.PokédexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokédexTheme {
                //define the navController
                val navController = rememberNavController()

                //create a NavHost where we define the navController and startDestination
                NavHost(
                    navController = navController,
                    startDestination = "pokemon_list_screen"
                ) {
                    //create different navScreens
                    composable("pokemon_list_screen") {

                    }
                    //details screen needs arguments to get the more data
                    composable(
                        //set argument name into the route using / and {}
                        route = "pokemon_detail_screen/{dominantColor}/{pokemonName}",
                        //create array of arguments
                        arguments = listOf(
                            //first argument
                            navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                            //second argument
                            navArgument("pokemonName") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        //get data from the argument
                        //get dominantColor
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }
                        //get pokemonName
                        val pokemonName = remember {
                            it.arguments?.getString("pokemonName")
                        }

                    }
                }
            }
        }
    }
}
