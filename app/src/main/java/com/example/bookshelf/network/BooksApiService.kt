package com.example.bookshelf.network

import com.example.bookshelf.model.BookItem
import com.example.bookshelf.model.BookSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Interfaz de servicio Retrofit para interactuar con la API de Google Books.
 * Documentación: https://developer.android.com/codelabs/basic-android-kotlin-compose-bookshelf
 */
interface BooksApiService {

    /**
     * Busca una lista de libros según la consulta proporcionada.
     * Ejemplo: https://www.googleapis.com/books/v1/volumes?q=jazz+history
     */
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String
    ): BookSearchResponse

    /**
     * Obtiene la información detallada de un libro específico según su ID.
     * Ejemplo: https://www.googleapis.com/books/v1/volumes/<volume_id>
     */
    @GET("volumes/{id}")
    suspend fun getBook(
        @Path("id") id: String
    ): BookItem
}
