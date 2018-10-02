package cl.entel.soa.gov.domain;

import java.util.ArrayList;
import java.util.List;

public class System {

    private String code;

    private String name;

    private String description;

    private List<Api> apis;

    public System(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.apis = new ArrayList<Api>();
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

    public List<Api> getApis() {
        return apis;
    }

    public void setApis(List<Api> apis) {
        this.apis = apis;
    }

}
