package net.iqbusiness.buhle.onlineregistrationapp.repositories;

import net.iqbusiness.buhle.onlineregistrationapp.dao.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;
    private Person person;

    @BeforeEach
    public void setUp(){
        person = Person
                .builder()
                .firstName("Buhle")
                .lastName("Mthembu")
                .idNumber("1234567890123")
                .contactNumber("1234567890")
                .build();
    }

    @AfterEach
    public void tearDown(){
        personRepository.deleteAll();
        person = null;
    }

    @Test
    void findByIdNumber() {
        personRepository.save(person);

        var searchedPerson = personRepository.findByIdNumber(person.getIdNumber());
        assertNotNull(searchedPerson);
    }
}