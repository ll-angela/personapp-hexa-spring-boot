package co.edu.javeriana.as.personapp.terminal.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Phone;
import co.edu.javeriana.as.personapp.terminal.model.TelefonoModelCli;

@Mapper
public class TelefonoMapperCli {

    public TelefonoModelCli fromDomainToAdapterCli (Phone phone) {
        TelefonoModelCli telefonoModelCli = new TelefonoModelCli();
        telefonoModelCli.setIdDuenio(phone.getOwner().getIdentification());
        telefonoModelCli.setOperador(phone.getCompany());
        telefonoModelCli.setNumero(phone.getNumber());
        return telefonoModelCli;
    }

    public Phone fromAdapterToDomain (TelefonoModelCli telefonoModelCli, Person person) {
        Phone phone = new Phone();
        phone.setOwner(person);
        phone.setNumber(telefonoModelCli.getNumero());
        phone.setCompany(telefonoModelCli.getOperador());
        return phone;
    }
}
