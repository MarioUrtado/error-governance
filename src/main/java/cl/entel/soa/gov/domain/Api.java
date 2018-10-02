package cl.entel.soa.gov.domain;

import java.util.ArrayList;
import java.util.List;

public class Api {

    private String code;

    private String name;

    private String description;

    private List<Operation> operations;

    public Api(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.operations = new ArrayList<Operation>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
