package br.com.ec.controller

import br.com.ec.model.Person
import br.com.ec.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById2(@PathVariable(value = "id") id: Long
    ): Person {
        return service.findById(id)
    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll2(): List<Person> {
        return service.findAll()
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create2(@RequestBody person: Person): Person {
        return service.create(person)
    }

    @PutMapping(produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun update2(@RequestBody person: Person): Person {
        return service.update(person)
    }

    @DeleteMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete2(@PathVariable(value = "id") id: Long) : ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }




}