package cl.entel.soa.gov.domain;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private String name;

    private Map<String, String> values;

    public Configuration(String name) {
        this.name = name;
        this.values = new HashMap<String, String>();
    }

    public Configuration(String name, Map<String, String> values) {
        this.name = name;
        this.values = values;
    }
}
