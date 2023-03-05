package br.com.ec.custom

import br.com.ec.data.vo.v2.BookVO
import br.com.ec.model.Book
import org.springframework.stereotype.Service

@Service
class BookMapper {

    fun mapEntityToVO(book: Book): BookVO {
        val  vo = BookVO()
        vo.key = book.id;
        vo.author = book.author;
        vo.title = book.title;
        vo.price = book.price;
        vo.launchDate = book.launchDate;
        return vo
    }
    fun mapVOToEntity(book: BookVO): Book {
        val entity = Book()
        entity.id = book.key;
        entity.author = book.author;
        entity.title = book.title;
        entity.price = book.price;
        entity.launchDate = book.launchDate;
        return entity
    }
}