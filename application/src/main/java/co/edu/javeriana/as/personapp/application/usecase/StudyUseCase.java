package co.edu.javeriana.as.personapp.application.usecase;

import co.edu.javeriana.as.personapp.application.port.in.StudyInputPort;
import co.edu.javeriana.as.personapp.application.port.out.ProfessionOutputPort;
import co.edu.javeriana.as.personapp.application.port.out.StudyOutputPort;
import co.edu.javeriana.as.personapp.common.annotations.UseCase;
import co.edu.javeriana.as.personapp.common.exceptions.NoExistException;
import co.edu.javeriana.as.personapp.domain.Profession;
import co.edu.javeriana.as.personapp.domain.Study;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Slf4j
@UseCase
public class StudyUseCase implements StudyInputPort {

    private StudyOutputPort studyPersistence;

    public StudyUseCase(@Qualifier("studyOutputAdapterMaria") StudyOutputPort studyPersistence) {
        this.studyPersistence = studyPersistence;
    }

    @Override
    public void setPersistence(StudyOutputPort studyPersistence) {
        this.studyPersistence = studyPersistence;
    }

    @Override
    public Study create(Study study) {
        log.debug("Into create on Application Domain");
        return studyPersistence.save(study);
    }

    @Override
    public Study edit(Integer idProfession, Integer idPerson, Study study) throws NoExistException {
        Study oldStudy = studyPersistence.findById(idProfession, idPerson);
        if (oldStudy != null)
            return studyPersistence.save(study);
        throw new NoExistException(
                "The study with idProfession " + idProfession + " and idPerson " + idPerson
                        + " does not exist into db, cannot be edited");
    }

    @Override
    public Boolean drop(Integer idProfession, Integer idPerson) throws NoExistException {
        Study oldStudy = studyPersistence.findById(idProfession, idPerson);
        if (oldStudy != null)
            return studyPersistence.delete(idProfession, idPerson);
        throw new NoExistException(
                "The study with idProfession " + idProfession + " and idPerson " + idPerson
                        + " does not exist into db, cannot be deleted");
    }

    @Override
    public List<Study> findAll() {
        log.info("Output: " + studyPersistence.getClass());
        return studyPersistence.find();
    }

    @Override
    public Study findOne(Integer idProfession, Integer idPerson) throws NoExistException {
        Study oldStudy = studyPersistence.findById(idProfession, idPerson);
        if (oldStudy != null)
            return oldStudy;
        throw new NoExistException(
                "The study with idProfession " + idProfession + " and idPerson " + idPerson
                        + " does not exist into db, cannot be found");
    }

    @Override
    public Integer count() {
        return findAll().size();
    }
}
