package net.iqbusiness.buhle.onlineregistrationapp.repositories;

import net.iqbusiness.buhle.onlineregistrationapp.dao.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findByIdNumber(String idNumber);
}