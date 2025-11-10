package com.example.questnavigasitugas_042.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.questnavigasitugas_042.R
import com.example.questnavigasitugas_042.viewmodel.FormData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanListPeserta(
    listpeserta: List<FormData>,
    onKeFormulirClicked:() -> Unit,
    onBerandaClicked: () -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.list_title), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_700)
                )
            )
        }
    ){ padding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            LazyColumn (
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ){
                items(listpeserta) { peserta ->
                    KartuPeserta(peserta = peserta )
                }
            }

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                OutlinedButton(onClick = onBerandaClicked) {
                    Text(stringResource(id = R.string.list_button_beranda))
                }
                Button(onClick = onKeFormulirClicked) {
                    Text(stringResource(id = R.string.list_button_formulir))
                }
            }
        }
    }
}

@Composable
fun KartuPeserta(peserta: FormData) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .height(150.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ){
        Column (
            modifier = Modifier.padding(16.dp)
        ){
            Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){
                Column (modifier = Modifier.weight(1f)){
                    InfoPeserta(label = stringResource(R.string.nama_lengkap),value = peserta.nama)
                    Spacer(modifier = Modifier.height(30.dp))
                    InfoPeserta(label = stringResource(R.string.sebagai), value = peserta.pemeran)
                }
