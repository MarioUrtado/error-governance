package cl.entel.soa.gov.model;

import org.apache.poi.ss.usermodel.Row;

public class MappingRowDTO extends DTO {

    public MappingRowDTO(Row row){
        super(row);
    }

    public String getSourceSystem() {
        return getNormalizeValue(1);
    }

    public String getDestinationSystem() {
        return getNormalizeValue(2);
    }

    public String getContext() {
        return getNormalizeValue(3);
    }

    public String getSourceCode() {
        return getNormalizeValue(4);
    }

    public String getDestinationCode() {
        return getNormalizeValue(5);
    }

    public String getField() {
        return getNormalizeValue(6);
    }

    public String getEntity() {
        return getNormalizeValue(7);
    }

    public String getConditionalContext(){
        return getConditionalValue(getContext());
    }

    public String getKey(){
        return getSourceCode()+ "@" + getDestinationCode()+ "@" +getContext()+ "@" +getSourceCode();
    }


}
