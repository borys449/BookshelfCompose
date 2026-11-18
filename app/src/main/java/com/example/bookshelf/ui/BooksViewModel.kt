package com.example.bookshelf.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.model.Book
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * Estados de la interfaz de usuario para la pantalla principal de Bookshelf.
 */
sealed interface BooksUiState {
    data class Success(val books: List<Book>) : BooksUiState
    object Error : BooksUiState
    object Loading : BooksUiState
}

/**
 * ViewModel encargado de la lógica de negocio y gestión del estado de la UI.
 */
class BooksViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    /** Estado observable de la UI */
    var booksUiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    /** Consulta actual realizada */
    var currentQuery: String by mutableStateOf("jazz history")
        private set

    init {
        getBooks(currentQuery)
    }

    /**
     * Obtiene la lista de libros desde el repositorio según el término de búsqueda.
     */
    fun getBooks(query: String = currentQuery) {
        currentQuery = query
        viewModelScope.launch {
            booksUiState = BooksUiState.Loading
            booksUiState = try {
                val books = booksRepository.getBooks(query)
                BooksUiState.Success(books)
            } catch (e: CancellationException) {
                throw e
            } catch (e: IOException) {
                BooksUiState.Error
            } catch (e: HttpException) {
                BooksUiState.Error
            } catch (e: Exception) {
                BooksUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookshelfApplication)
                val booksRepository = application.container.booksRepository
                BooksViewModel(booksRepository = booksRepository)
            }
        }
    }
}
