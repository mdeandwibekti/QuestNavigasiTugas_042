package com.example.questnavigasitugas_042.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class FormData(
    val nama: String,
    val gender: String,
    val pemeran: String,
    val agama: String
)

class DataViewModel : ViewModel() {

    private val _pesertaList = mutableStateListOf<FormData>()
    val pesertaList: List<FormData> = _pesertaList

    fun tambahPeserta(nama: String, jk: String, pemeran: String, agama: String) {
        val pesertaBaru = FormData(nama, jk, pemeran, agama)
        _pesertaList.add(pesertaBaru)
    }

}