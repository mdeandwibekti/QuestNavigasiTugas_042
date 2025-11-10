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
    init {
        val dataList = listOf(
            FormData(
                nama = "Arbani Yazid",
                gender = "Laki - Laki",
                pemeran = "Dilan",
                agama = "Islam"
            ),
            FormData(
                nama = "Zee Ashadel",
                gender = "Perempuan",
                pemeran = "Anchika",
                agama = "Islam"
            ),
            FormData(
                nama = "Caitlin Halderman",
                gender = "Perempuan",
                pemeran = "Milea",
                agama = "Islam"
            ),
            FormData(
                nama = "Jefan Nathanio",
                gender = "Laki - Laki",
                pemeran = "Bono",
                agama = "Kristen"
            ),
            FormData(
                nama = "Daffa Wardhana",
                gender = "Laki - Laki",
                pemeran = "Yadit",
                agama = "Islam"
            )
        )
        _pesertaList.addAll(dataList)
    }
}