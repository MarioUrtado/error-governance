package cl.entel.soa.gov.domain;

public class Endpoint {

    private String transport;

    private String instance;

    private Configuration configuration;

    public Endpoint(String transport, Configuration configuration) {
        this.transport = transport;
        this.configuration = configuration;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }
}
