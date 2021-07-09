package com.example.retrofitkotlin.model

data class Item(
    val etag: String,
    val id: String,
    val kind: String,
    val volumeInfo: VolumeInfo
)