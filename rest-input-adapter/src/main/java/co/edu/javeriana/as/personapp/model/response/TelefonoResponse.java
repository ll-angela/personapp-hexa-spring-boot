package co.edu.javeriana.as.personapp.model.response;

import co.edu.javeriana.as.personapp.model.request.TelefonoRequest;

public class TelefonoResponse extends TelefonoRequest {

    private String status;

    public TelefonoResponse (String number, String oper, String owner, String database, String status) {
        super(number, oper, owner, database);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}