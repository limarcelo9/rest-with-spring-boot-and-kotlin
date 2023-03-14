package br.com.ec.controller

import br.com.ec.data.vo.v1.BookVO
import br.com.ec.data.vo.v1.PersonVO
import br.com.ec.services.BookService
import br.com.ec.data.vo.v2.PersonVO as PersonVOv2
import br.com.ec.services.PersonService
import br.com.ec.util.MediaType
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/books/v1")
@Tag(name = "Book", description = "endpoint for manage books")
class BookController {

    @Autowired
    private lateinit var service: BookService

    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary = "Finds a Book", description = "Finds a Book",
        tags = ["Book"],
        responses = [
            ApiResponse(description = "Success",responseCode = "200", content = [
                Content(schema = Schema(implementation = BookVO::class))
            ]),
            ApiResponse(description = "No Content", responseCode = "204", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ])
        ]
    )
    fun findById2(@PathVariable(value = "id") id: Long
    ): BookVO {
        return service.findById(id)
    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary = "Finds all Books", description = "Finds all Books",
        tags = ["Book"],
        responses = [
            ApiResponse(description = "Success",responseCode = "200", content = [
                Content(array = ArraySchema(schema = Schema(implementation = BookVO::class)))
            ]),
            ApiResponse(description = "No Content", responseCode = "204", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ])
        ]
    )
    fun findAll2(): List<BookVO> {
        return service.findAll()
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
        consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary = "Adds a Book", description = "Adds a Book",
        tags = ["Book"],
        responses = [
            ApiResponse(description = "Success",responseCode = "200", content = [
                Content(schema = Schema(implementation = BookVO::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ])
        ]
    )
    fun create2(@RequestBody book: BookVO): BookVO {
        return service.create(book)
    }

    @PutMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
        consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary = "Updates a book information", description = "Updates a book information",
        tags = ["Book"],
        responses = [
            ApiResponse(description = "Success",responseCode = "200", content = [
                Content(schema = Schema(implementation = BookVO::class))
            ]),
            ApiResponse(description = "No Content", responseCode = "204", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ])
        ]
    )
    fun update2(@RequestBody book: BookVO): BookVO {
        return service.update(book)
    }

    @DeleteMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @Operation(summary = "Deletes a book", description = "Deletes a book",
        tags = ["Book"],
        responses = [
            ApiResponse(description = "No Content", responseCode = "204", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ])
        ]
    )
    fun delete2(@PathVariable(value = "id") id: Long) : ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }

}