package com.example.meet14.model

data class Mahasiswa(
    val nama: String,
    val nim: String,
    val alamat: String,
    val jenisKelamin: String,
    val kelas: String,
    val angkatan: String,
    val judulSkripsi: String,
    val dosenPembimbing1: String,
    val dosenPembimbing2: String
) {
    constructor() : this (
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "")
    {

    }
}
