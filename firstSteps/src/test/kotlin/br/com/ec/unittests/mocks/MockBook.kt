package br.com.ec.unittests.mocks

import br.com.ec.data.vo.v1.BookVO
import br.com.ec.model.Book
import java.util.*

class MockBook {
    fun mockEntity(): Book {
        return mockEntity(0)
    }

    fun mockVO(): BookVO {
        return mockVO(0)
    }

    fun mockEntityList(): ArrayList<Book> {
        val books: ArrayList<Book> = ArrayList<Book>()
        for (i in 0..13) {
            books.add(mockEntity(i))
        }
        return books
    }

    fun mockVOList(): ArrayList<BookVO> {
        val books: ArrayList<BookVO> = ArrayList()
        for (i in 0..13) {
            books.add(mockVO(i))
        }
        return books
    }

    fun mockEntity(number: Int): Book {
        val book = Book()
        book.id = number.toLong()
        book.title = "Address Test$number"
        book.author = "First Name Test$number"
        book.price = if (number % 2 == 0) 200.00 else 100.00
        book.launchDate =  Date()
        return book
    }

    fun mockVO(number: Int): BookVO {
        val book = BookVO()
        book.key = number.toLong()
        book.title = "Address Test$number"
        book.author = "First Name Test$number"
        book.price = if (number % 2 == 0) 200.00 else 100.00
        book.launchDate =  Date()
        return book
    }
}