package br.com.ec.custom

import br.com.ec.data.vo.v2.PersonVO
import br.com.ec.model.Person
import org.springframework.stereotype.Service

@Service
class PersonMapper {

    fun mapEntityToVO(person: Person): PersonVO {
        val  vo = PersonVO()
        vo.id = person.id;
        vo.address = person.address;
        vo.firstName = person.firstName;
        vo.lastName = person.lastName;
        vo.gender = person.gender;
        return vo
    }
    fun mapVOToEntity(person: PersonVO): Person {
        val entity = Person()
        entity.id = person.id;
        entity.address = person.address;
        entity.firstName = person.firstName;
        entity.lastName = person.lastName;
        entity.gender = person.gender;
//        entity.bir = person.birthDay;
        return entity
    }
}