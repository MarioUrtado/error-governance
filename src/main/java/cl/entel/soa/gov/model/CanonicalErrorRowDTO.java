package cl.entel.soa.gov.model;

import org.apache.poi.ss.usermodel.Row;

public class CanonicalErrorRowDTO extends DTO {

    protected String getConditionalValue(String value){
        if (value.equals("")){
            value = "IS NULL";
        } else {
            value = " = '" + value + "'";
        }

        return value;
    }

    public CanonicalErrorRowDTO(Row row) {
        super(row);
    }

    public String getCode() {
        return getNormalizeValue(1);
    }

    public String getType() {
        return getNormalizeValue(3);
    }

    public String getDescription() {
        return getNormalizeValue(2);
    }

    public String getSelf(){
        return "CODE: "+ getCode() +" - TYPE: "+ getType() +" - DESCRIPTION: " + getDescription();
    }

}
