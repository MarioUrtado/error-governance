package cl.entel.soa.gov.domain;

public class Operation {

    private String name;

    private String version;

    private String description;

    private Endpoint endpoint;

    public Operation(String name, String version, String description, Endpoint endpoint) {
        this.name = name;
        this.version = version;
        this.description = description;
        this.endpoint = endpoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }
}
