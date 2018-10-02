package cl.entel.soa.gov.model;

import org.apache.poi.ss.usermodel.Row;

public class SystemDTO extends DTO {

    public SystemDTO(Row row) {
        super(row);
    }

    public String getCode(){
        System.out.println(this.row);
        return getNormalizeValue(10);
    }

    public String getName(){
        return getNormalizeValue(2);
    }

    public String getDescription(){
        return getNormalizeValue(3);
    }

    public String getType(){
        return getNormalizeValue(6);
    }
}
