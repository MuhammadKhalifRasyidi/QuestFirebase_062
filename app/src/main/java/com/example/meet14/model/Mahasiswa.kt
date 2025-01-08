package com.example.meet14.model

data class Mahasiswa(
    val nama: String,
    val nim: String,
    val alamat: String,
    val jenisKelamin: String,
    val kelas: String,
    val angkatan: String
) {
    constructor() : this (
        "",
        "",
        "",
        "",
        "",
        "")
    {

    }
}
