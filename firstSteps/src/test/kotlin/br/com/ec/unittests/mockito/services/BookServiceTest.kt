package br.com.ec.unittests.mockito.services

import br.com.ec.repository.BookRepository
import br.com.ec.services.BookService
import br.com.ec.unittests.mocks.MockBook
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class BookServiceTest {

    private lateinit var inputObject: MockBook

    @InjectMocks
    private lateinit var service: BookService

    private lateinit var repository: BookRepository

    fun setUpMock() {
        inputObject = MockBook()
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun findAll() {
        val list  = inputObject.mockEntityList()
        `when`(repository.findAll()).thenReturn(list)

        val books = service.findAll()
    }
}
