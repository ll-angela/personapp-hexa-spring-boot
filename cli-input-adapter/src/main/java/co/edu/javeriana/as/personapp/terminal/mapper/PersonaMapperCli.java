package co.edu.javeriana.as.personapp.terminal.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Gender;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.terminal.model.PersonaModelCli;

@Mapper
public class PersonaMapperCli {

	public PersonaModelCli fromDomainToAdapterCli(Person person) {
		PersonaModelCli personaModelCli = new PersonaModelCli();
		personaModelCli.setCc(person.getIdentification());
		personaModelCli.setNombre(person.getFirstName());
		personaModelCli.setApellido(person.getLastName());
		personaModelCli.setGenero(person.getGender().toString());
		personaModelCli.setEdad(person.getAge());
		return personaModelCli;
	}

	public Person fromAdapterToDomain (PersonaModelCli personaModelCli) {
		Person person = new Person();
		person.setIdentification(personaModelCli.getCc());
		person.setFirstName(personaModelCli.getNombre());
		person.setLastName(personaModelCli.getApellido());
		person.setAge(personaModelCli.getEdad());
		switch (personaModelCli.getGenero().toLowerCase()) {
			case "male":
				person.setGender(Gender.MALE);
				break;
			case "female":
				person.setGender(Gender.FEMALE);
				break;
			default:
				person.setGender(Gender.OTHER);
				break;
		}
		return person;
	}
}
