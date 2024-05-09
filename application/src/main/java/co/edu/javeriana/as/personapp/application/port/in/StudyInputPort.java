package co.edu.javeriana.as.personapp.application.port.in;

import co.edu.javeriana.as.personapp.application.port.out.StudyOutputPort;
import co.edu.javeriana.as.personapp.common.annotations.Port;
import co.edu.javeriana.as.personapp.common.exceptions.NoExistException;
import co.edu.javeriana.as.personapp.domain.Study;

import java.util.List;

@Port
public interface StudyInputPort {

    public void setPersistence(StudyOutputPort studyPersistence);

    public Study create(Study study);

    public Study edit(Integer idProfession, Integer idPerson, Study study) throws NoExistException;

    public Boolean drop(Integer idProfession, Integer idPerson) throws NoExistException;

    public List<Study> findAll();

    public Study findOne(Integer idProfession, Integer idPerson) throws NoExistException;

    public Integer count();
}
