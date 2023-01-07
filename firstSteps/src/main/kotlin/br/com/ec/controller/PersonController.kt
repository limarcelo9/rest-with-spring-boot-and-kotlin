package br.com.ec.controller

import br.com.ec.model.Person
import br.com.ec.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable(value = "id") id: Long
    ): Person {
        return service.findById(id)
    }

    @RequestMapping(method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<Person> {
        return service.findAll()
    }

    @RequestMapping(method = [RequestMethod.POST], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody person: Person): Person {
        return service.create(person)
    }

    @RequestMapping(method = [RequestMethod.PUT], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody person: Person): Person {
        return service.update(person)
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.DELETE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable(value = "id") id: Long) {
        service.delete(id)
    }




}