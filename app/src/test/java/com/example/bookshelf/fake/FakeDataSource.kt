package com.example.bookshelf.fake

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.BookItem
import com.example.bookshelf.model.BookSearchResponse
import com.example.bookshelf.model.ImageLinks
import com.example.bookshelf.model.VolumeInfo

/**
 * Datos falsos de prueba para verificar las llamadas a la API y el repositorio.
 */
object FakeDataSource {

    const val bookId1 = "id_1"
    const val bookTitle1 = "Jazz History Volume 1"
    const val bookThumbnail1 = "http://books.google.com/books/content?id=id_1&img=1"

    const val bookId2 = "id_2"
    const val bookTitle2 = "Jazz History Volume 2"
    const val bookThumbnail2 = "http://books.google.com/books/content?id=id_2&img=1"

    val bookItem1 = BookItem(
        id = bookId1,
        volumeInfo = VolumeInfo(
            title = bookTitle1,
            description = "Descripción de prueba 1",
            imageLinks = ImageLinks(
                smallThumbnail = bookThumbnail1,
                thumbnail = bookThumbnail1
            )
        )
    )

    val bookItem2 = BookItem(
        id = bookId2,
        volumeInfo = VolumeInfo(
            title = bookTitle2,
            description = "Descripción de prueba 2",
            imageLinks = ImageLinks(
                smallThumbnail = bookThumbnail2,
                thumbnail = bookThumbnail2
            )
        )
    )

    val bookSearchResponse = BookSearchResponse(
        items = listOf(bookItem1, bookItem2),
        totalItems = 2
    )

    val expectedBooks = listOf(
        Book(
            id = bookId1,
            title = bookTitle1,
            thumbnail = bookThumbnail1.replace("http:", "https:")
        ),
        Book(
            id = bookId2,
            title = bookTitle2,
            thumbnail = bookThumbnail2.replace("http:", "https:")
        )
    )
}
