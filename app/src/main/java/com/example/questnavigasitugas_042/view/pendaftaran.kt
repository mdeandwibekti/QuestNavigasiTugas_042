package com.example.questnavigasitugas_042.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.questnavigasitugas_042.R
import com.example.questnavigasitugas_042.viewmodel.DataViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanFormulir(
    jenisK: List<String> = listOf("Laki-laki", "Perempuan"),
    listAgama: List<String> = listOf("Islam", "Kristen", "Katolik", "Hindu", "Budha", "Konghucu"),
    viewModel: DataViewModel,
    onNavigateBack: () -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf(jenisK[0]) }
    var pemeran by remember { mutableStateOf("") }
    var agama by remember { mutableStateOf(listAgama[0]) }
    var isAgamaDropdownExpanded by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val toastMessage = stringResource(id = R.string.submit_toast)

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.form_title), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = nama,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                label = { Text(text = stringResource(id = R.string.nama_lengkap)) },
                placeholder = { Text(text = stringResource(id = R.string.nama_placeholder)) },
                onValueChange = { nama = it },
            )

}