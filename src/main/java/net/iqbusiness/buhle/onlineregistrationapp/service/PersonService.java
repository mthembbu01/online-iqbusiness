package net.iqbusiness.buhle.onlineregistrationapp.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import net.iqbusiness.buhle.onlineregistrationapp.Utils.MapperUtil;
import net.iqbusiness.buhle.onlineregistrationapp.dto.PersonDto;
import net.iqbusiness.buhle.onlineregistrationapp.dao.Person;
import net.iqbusiness.buhle.onlineregistrationapp.exceptions.PersonNotFoundException;
import net.iqbusiness.buhle.onlineregistrationapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IService<PersonDto> {

	private final PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public PersonDto getOne(String idNumber){
		var personDB = personRepository.findByIdNumber(idNumber);

		if(Objects.isNull(personDB)){
			throw new PersonNotFoundException("Could not find person idNumber = " + idNumber);
		}

		return MapperUtil.dtoFromEntity(personDB);
	}

	@Override
	public List<PersonDto> getAll(){
		var personDB = personRepository.findAll();

		if(personDB.isEmpty()){
			throw new PersonNotFoundException("Could not find any persons");
		}

		return personRepository.findAll()
				.stream()
				.map(MapperUtil::dtoFromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public PersonDto save(PersonDto person){
			Person personDB = personRepository.save(MapperUtil.entityFromDto(person));

			return  MapperUtil.dtoFromEntity(personDB);
	}

	@Override
	public PersonDto updateOne(PersonDto person){
		Person personBeingUpdatedDB = personRepository.findByIdNumber(person.getIdNumber());

		if(Objects.isNull(personBeingUpdatedDB)){
			throw new PersonNotFoundException("Could not find person idNumber = " + person.getIdNumber());
		}

		MapperUtil.updatePerson(personBeingUpdatedDB,person);

		return MapperUtil.dtoFromEntity(personRepository.save(personBeingUpdatedDB));
	}

	@Override
	public void deleteOne(PersonDto person) {
		personRepository.delete(MapperUtil.entityFromDto(person));
	}

	@Override
	public void deleteOne(Long id) {
		personRepository.deleteById(id);
	}
}
