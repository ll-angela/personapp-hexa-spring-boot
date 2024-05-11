package co.edu.javeriana.as.personapp.model.response;

import co.edu.javeriana.as.personapp.model.request.EstudiosRequest;

public class EstudiosResponse extends EstudiosRequest {

    private String status;

    public EstudiosResponse (String ccPer, String idProf, String date, String university, String database, String status) {
        super(ccPer, idProf, date, university, database);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
