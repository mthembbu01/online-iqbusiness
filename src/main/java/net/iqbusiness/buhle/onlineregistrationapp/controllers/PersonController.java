package net.iqbusiness.buhle.onlineregistrationapp.controllers;

import net.iqbusiness.buhle.onlineregistrationapp.dto.PersonDto;
import net.iqbusiness.buhle.onlineregistrationapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/api/persons")
public class PersonController {
	private final PersonService personService;

	@Autowired
	public PersonController(PersonService apiService) {
		this.personService = apiService;
	}

	@GetMapping()
	public ResponseEntity<List<PersonDto>> findAll() {
		var persons = personService.getAll();
		var status = !persons.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return  new ResponseEntity<>(persons, status);
	}

	@GetMapping("/{idNumber}")
	public ResponseEntity<PersonDto> findOneByIdNumber(@PathVariable String idNumber) {
		var person = personService.getOne(idNumber);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<PersonDto> addPerson(@Valid @RequestBody PersonDto person) {
		var savedPerson = personService.save(person);
		return new ResponseEntity<>(savedPerson, HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<PersonDto> updateByIdNumber(@Valid @RequestBody PersonDto person) {
		var personUpdated = personService.updateOne(person);
		return new ResponseEntity<>(personUpdated, HttpStatus.OK);
	}
}