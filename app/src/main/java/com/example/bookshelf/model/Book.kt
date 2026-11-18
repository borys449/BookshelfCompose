package com.example.bookshelf.model

import com.google.gson.annotations.SerializedName

/**
 * Respuesta devuelta por la API de Google Books al buscar volúmenes:
 * https://www.googleapis.com/books/v1/volumes?q=<query>
 */
data class BookSearchResponse(
    @SerializedName("items")
    val items: List<BookItem>? = null,
    @SerializedName("totalItems")
    val totalItems: Int? = null
)

/**
 * Representación de un ítem de libro devuelto por la API.
 */
data class BookItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo? = null
)

/**
 * Información del volumen que contiene el título, descripción y enlaces a imágenes.
 */
data class VolumeInfo(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("imageLinks")
    val imageLinks: ImageLinks? = null
)

/**
 * Enlaces a miniaturas proporcionados por la API de Google Books.
 */
data class ImageLinks(
    @SerializedName("smallThumbnail")
    val smallThumbnail: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null
)

/**
 * Modelo de datos simplificado utilizado por la capa de IU para representar un libro.
 */
data class Book(
    val id: String,
    val title: String,
    val thumbnail: String?
)
