package cl.entel.soa.gov.domain;

public class Target {

    private String provider;

    private String api;

    private String operation;

    private String version;

    public Target(String provider, String api, String operation, String version) {
        this.provider = provider;
        this.api = api;
        this.operation = operation;
        this.version = version;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
