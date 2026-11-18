package com.example.bookshelf.fake

import com.example.bookshelf.model.BookItem
import com.example.bookshelf.model.BookSearchResponse
import com.example.bookshelf.network.BooksApiService

/**
 * Servicio falso de red que simula la respuesta de la API de Google Books sin realizar llamadas HTTP reales.
 */
class FakeBooksApiService : BooksApiService {

    override suspend fun searchBooks(query: String): BookSearchResponse {
        return FakeDataSource.bookSearchResponse
    }

    override suspend fun getBook(id: String): BookItem {
        return when (id) {
            FakeDataSource.bookId1 -> FakeDataSource.bookItem1
            FakeDataSource.bookId2 -> FakeDataSource.bookItem2
            else -> throw IllegalArgumentException("Libro no encontrado para el ID: $id")
        }
    }
}
