package br.com.ec.services

import br.com.ec.controller.PersonController
import br.com.ec.custom.PersonMapper
import br.com.ec.data.vo.v1.PersonVO
import br.com.ec.data.vo.v2.PersonVO as PersonVOV2
import br.com.ec.exceptions.ResourceNotFoundException
import br.com.ec.unittests.mapper.DozerMapper
import br.com.ec.model.Person
import br.com.ec.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: PersonMapper

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO> {
        logger.info("Finding all people!")
        val persons = repository.findAll()
        return DozerMapper.parseListObjects(persons, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding one person!")
        val person =  repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        var personVO: PersonVO =  DozerMapper.parseObject(person, PersonVO::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRel)
        return personVO;
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("Create one person!")

        var entity: Person = DozerMapper.parseObject(person, Person::class.java)
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun update(person: PersonVO): PersonVO {
        logger.info("Update one person!")
        val entity =  repository.findById(person.key)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun delete(id: Long) {
        logger.info("Delete one person!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }

    fun createV2(person: PersonVOV2): PersonVOV2 {
        logger.info("Create one person!")

        var entity: Person = mapper.mapVOToEntity(person)
        return mapper.mapEntityToVO(repository.save(entity))
    }

}