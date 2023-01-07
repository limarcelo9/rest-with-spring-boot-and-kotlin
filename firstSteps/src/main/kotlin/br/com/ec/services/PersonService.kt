package br.com.ec.services

import br.com.ec.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people!")
        val persons: MutableList<Person> = ArrayList()
        for(i in 0 .. 7) {
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person!")
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Marcelo"
        person.lastName = "Lima"
        person.address = "Brasilia"
        person.gender = "Male"
        return person
    }

    fun create(person: Person): Person {
        logger.info("Create one person!")
        return person
    }

    fun update(person: Person): Person {
        logger.info("Update one person!")
        return person
    }

    fun delete(id: Long) {
        logger.info("Delete one person!")
    }


    private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Marcelo $i"
        person.lastName = "Lima $i"
        person.address = "Brasilia $i"
        person.gender = "Male $i"

        return person
    }

}