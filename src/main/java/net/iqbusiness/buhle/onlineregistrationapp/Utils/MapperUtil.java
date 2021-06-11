package net.iqbusiness.buhle.onlineregistrationapp.Utils;

import net.iqbusiness.buhle.onlineregistrationapp.dto.PersonDto;
import net.iqbusiness.buhle.onlineregistrationapp.dao.Person;

public class MapperUtil {

    /**
     * Takes a DTO and return a new equivalent Entity
     * @param personDto DTO from front-end
     * @return entity constructed from incoming DTO
     */
    public static Person entityFromDto(PersonDto personDto) {
        //@Todo update this to use ModelMapper
        return Person.builder()
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .idNumber(personDto.getIdNumber())
                .contactNumber(personDto.getContactNumber())
                .build();
    }

    /**
     * Takes a Entity and return a new equivalent DTO
     * @param personEntity entity from DB
     * @return DTO constructed from entity
     */
    public static PersonDto dtoFromEntity(Person personEntity) {
        //@Todo update this to use ModelMapper
        return PersonDto.builder()
                .firstName(personEntity.getFirstName())
                .lastName(personEntity.getLastName())
                .idNumber(personEntity.getIdNumber())
                .contactNumber(personEntity.getContactNumber())
                .build();
    }

    /**
     * Mapps the {@link Person} from the incoming {@link PersonDto}
     * @param personDB existing user in the DB
     * @param personDto incoming user with updates
     */
    public static void updatePerson(Person personDB, PersonDto personDto){
        //@Todo update this to use ModelMapper
        personDB.setFirstName(personDto.getFirstName());
        personDB.setLastName(personDto.getLastName());
        personDB.setContactNumber(personDto.getContactNumber());
    }
}

