package com.example.bookshelf.data

import com.example.bookshelf.network.BooksApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Contenedor de dependencias para la aplicación Bookshelf.
 */
interface AppContainer {
    val booksRepository: BooksRepository
}

/**
 * Implementación predeterminada del contenedor de dependencias.
 * Proporciona el servicio Retrofit configurado con Gson y la implementación del repositorio de red.
 */
class DefaultAppContainer : AppContainer {

    private val baseUrl = "https://www.googleapis.com/books/v1/"

    /**
     * Instancia de Retrofit con convertidor Gson según las especificaciones del codelab.
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    /**
     * Servicio de la API de Google Books.
     */
    private val retrofitService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }

    /**
     * Repositorio de red inyectable en los ViewModels.
     */
    override val booksRepository: BooksRepository by lazy {
        NetworkBooksRepository(retrofitService)
    }
}
