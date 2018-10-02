package cl.entel.soa.gov.model;

import org.apache.poi.ss.usermodel.Row;

public class ProviderRowDTO extends DTO {

    public ProviderRowDTO(Row row) {
        super(row);
    }

    public String getSystemCode(){
        return getNormalizeValue(1);
    }

    public String getApiCode(){
        return getNormalizeValue(2);
    }

    public String getOperationName(){
        return getNormalizeValue(3);
    }

    public String getOperationVersion(){
        return getNormalizeValue(4);
    }

    public String getTransport(){
        return getNormalizeValue(5);
    }

    public String getInstance(){
        return getNormalizeValue(6);
    }

    public String getConfigName(){
        return getNormalizeValue(7);
    }

    public String getConfigValue(){
        return getNormalizeValue(8);
    }

    public String getConfigProperty(){
        return getNormalizeValue(9);
    }
}
