package co.edu.javeriana.as.personapp.terminal.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Profession;
import co.edu.javeriana.as.personapp.terminal.model.ProfesionModelCli;

@Mapper
public class ProfesionMapperCli {

    public ProfesionModelCli fromDomainToAdapterCli (Profession profession) {
        ProfesionModelCli profesionModelCli = new ProfesionModelCli();
        profesionModelCli.setId(profession.getIdentification());
        profesionModelCli.setNombre(profession.getName());
        profesionModelCli.setDescripción(profession.getDescription());
        return profesionModelCli;
    }

    public Profession fromAdapterToDomain (ProfesionModelCli profesionModelCli) {
        Profession profession = new Profession();
        profession.setIdentification(profesionModelCli.getId());
        profession.setName(profesionModelCli.getNombre());
        profession.setDescription(profesionModelCli.getDescripción());
        return profession;
    }
}
