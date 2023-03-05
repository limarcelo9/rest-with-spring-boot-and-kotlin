package br.com.ec.services

import br.com.ec.controller.BookController
import br.com.ec.custom.BookMapper
import br.com.ec.data.vo.v1.BookVO
import br.com.ec.exceptions.ResourceNotFoundException
import br.com.ec.mapper.DozerMapper
import br.com.ec.model.Book
import br.com.ec.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class BookService {

    @Autowired
    private lateinit var repository: BookRepository

    @Autowired
    private lateinit var mapper: BookMapper

    private val logger = Logger.getLogger(BookService::class.java.name)

    fun findAll(): List<BookVO> {
        logger.info("Finding all books!")
        val books = repository.findAll()
        return DozerMapper.parseListObjects(books, BookVO::class.java)
    }

    fun findById(id: Long): BookVO {
        logger.info("Finding one book!")
        val book =  repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        var bookVO: BookVO =  DozerMapper.parseObject(book, BookVO::class.java)
        val withSelfRel = linkTo(BookController::class.java).slash(bookVO.key).withSelfRel()
        bookVO.add(withSelfRel)
        return bookVO;
    }

    fun create(book: BookVO): BookVO {
        logger.info("Create one book!")

        var entity: Book = DozerMapper.parseObject(book, Book::class.java)
        return DozerMapper.parseObject(repository.save(entity), BookVO::class.java)
    }

    fun update(book: BookVO): BookVO {
        logger.info("Update one book!")
        val entity =  repository.findById(book.key)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.author = book.author
        entity.title = book.title
        entity.price = book.price
        entity.launchDate = book.launchDate

        return DozerMapper.parseObject(repository.save(entity), BookVO::class.java)
    }

    fun delete(id: Long) {
        logger.info("Delete one book!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }



}