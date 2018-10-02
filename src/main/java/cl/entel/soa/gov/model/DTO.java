package cl.entel.soa.gov.model;

import org.apache.poi.ss.usermodel.Row;

public class DTO {

    protected Row row;

    public DTO(Row row) {
        this.row = row;
    }

    protected String getNormalizeValue(int i){

        String value;
        try{
            value = row.getCell(i).getStringCellValue();
        } catch (NullPointerException e ){
            value = "";
        } catch (IllegalStateException e){
            Double numericCellValue =  row.getCell(i).getNumericCellValue();
            Long longValue = numericCellValue.longValue();
            value = new String(longValue.toString());
        }
        return value;
    }

    protected String getConditionalValue(String value){
        if (value.equals("")){
            value = "IS NULL";
        } else {
            value = " = '" + value + "'";
        }
        return value;
    }
}
