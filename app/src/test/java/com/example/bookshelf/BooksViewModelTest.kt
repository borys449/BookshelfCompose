package com.example.bookshelf

import com.example.bookshelf.fake.FakeBooksRepository
import com.example.bookshelf.fake.FakeDataSource
import com.example.bookshelf.rules.TestDispatcherRule
import com.example.bookshelf.ui.BooksUiState
import com.example.bookshelf.ui.BooksViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

/**
 * Pruebas unitarias para [BooksViewModel].
 */
class BooksViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun booksViewModel_getBooks_verifyBooksUiStateSuccess() = runTest {
        val booksViewModel = BooksViewModel(
            booksRepository = FakeBooksRepository()
        )
        // Tras la inicialización, booksUiState debe ser Success con los libros esperados
        assertTrue(booksViewModel.booksUiState is BooksUiState.Success)
        val successState = booksViewModel.booksUiState as BooksUiState.Success
        assertEquals(FakeDataSource.expectedBooks, successState.books)
    }
}
