package net.iqbusiness.buhle.onlineregistrationapp.exceptions;

import net.iqbusiness.buhle.onlineregistrationapp.dao.Person;

public class PersonNotFoundException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public PersonNotFoundException() {
		super();
	}

	public PersonNotFoundException(String message) {
		super(message);
	}

	public PersonNotFoundException(String message, long id) {
		super(message + id);
	}

	public PersonNotFoundException(String message, Person person) {
		super(person.getClass().getName() + message);
	}

}
