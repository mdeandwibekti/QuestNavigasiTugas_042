
package com.example.questnavigasitugas_042.navigasi

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasitugas_042.view.HalamanFormulir
import com.example.questnavigasitugas_042.view.HalamanListPeserta
import com.example.questnavigasitugas_042.view.HalamanWelcome
import com.example.questnavigasitugas_042.viewmodel.DataViewModel


enum class PengelolaHalaman {
    Welcome,
    ListPeserta,
    Formulir
}

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    val viewModel: DataViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = PengelolaHalaman.Welcome.name
    ) {
        composable(route = PengelolaHalaman.Welcome.name) {
            HalamanWelcome(
                onMasukClicked = {
                    navController.navigate(PengelolaHalaman.ListPeserta.name)
                }
            )
        }

        composable(route = PengelolaHalaman.ListPeserta.name) {
            HalamanListPeserta(
                listpeserta = viewModel.pesertaList,
                onKeFormulirClicked = {
                    navController.navigate(PengelolaHalaman.Formulir.name)
                },
                onBerandaClicked = {
                    // Kembali ke halaman Welcome
                    navController.popBackStack(PengelolaHalaman.Welcome.name, inclusive = false)
                }
            )
        }

        composable(route = PengelolaHalaman.Formulir.name) {
            HalamanFormulir(
                viewModel = viewModel,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}