package com.example.retrofitkotlin.model

data class VolumeInfo(
    val authors: List<String?>,
    val averageRating: Double,
    val imageLinks: ImageLinks,
    val maturityRating: String,
    val pageCount: Int?,
    val publishedDate: String,
    val publisher: String,
    val ratingsCount: Int,
    val subtitle: String,
    val title: String?,
    val previewLink : String?,
)