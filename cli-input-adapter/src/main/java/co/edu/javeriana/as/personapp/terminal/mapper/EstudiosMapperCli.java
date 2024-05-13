package co.edu.javeriana.as.personapp.terminal.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Profession;
import co.edu.javeriana.as.personapp.domain.Study;
import co.edu.javeriana.as.personapp.terminal.model.EstudiosModelCli;

@Mapper
public class EstudiosMapperCli {

    public EstudiosModelCli fromDomainToAdapterCli (Study study) {
        EstudiosModelCli estudiosModelCli = new EstudiosModelCli();
        estudiosModelCli.setIdDuenio(study.getPerson().getIdentification());
        estudiosModelCli.setIdProfesion(study.getProfession().getIdentification());
        estudiosModelCli.setFechaGrad(study.getGraduationDate());
        estudiosModelCli.setUniversidad(study.getUniversityName());
        return estudiosModelCli;
    }

    public Study fromAdapterToDomain (EstudiosModelCli estudiosModelCli, Person person, Profession profession) {
        Study study = new Study();
        study.setPerson(person);
        study.setProfession(profession);
        study.setUniversityName(estudiosModelCli.getUniversidad());
        study.setGraduationDate(estudiosModelCli.getFechaGrad());
        return study;
    }
}
