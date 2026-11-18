package com.example.bookshelf.fake

import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.model.Book

/**
 * Repositorio falso para pruebas del ViewModel.
 */
class FakeBooksRepository : BooksRepository {

    override suspend fun getBooks(query: String): List<Book> {
        return FakeDataSource.expectedBooks
    }

    override suspend fun getBook(id: String): Book {
        return FakeDataSource.expectedBooks.first { it.id == id }
    }
}
