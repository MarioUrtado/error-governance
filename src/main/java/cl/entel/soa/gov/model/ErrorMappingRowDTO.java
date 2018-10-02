package cl.entel.soa.gov.model;

import org.apache.poi.ss.usermodel.Row;

public class ErrorMappingRowDTO {

    private Row row;

    public ErrorMappingRowDTO(Row row) {
        this.row = row;
    }

    protected String getNormalizeValue(int i){
        String value;
        try{
            value = row.getCell(i).getStringCellValue().replace("'", "''");
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

    public String getSystem() {
        return getNormalizeValue(1);
    }

    public String getModule() {
        return getNormalizeValue(2);
    }

    public String getSubModule() {
        return getNormalizeValue(3);
    }

    public String getRawCode() {
        return getNormalizeValue(4);
    }

    public String getRawDescription() {
        return getNormalizeValue(5);
    }

    public String getCanonicalCode() {
        return getNormalizeValue(6);
    }

    public String getCanonicalDescription() {
        return getNormalizeValue(7);
    }

    public String getCanonicalType() {
        return getNormalizeValue(8);
    }

    public String getStatus() {
        return getNormalizeValue(9).replace(" ", "");
    }

    public String getHttpCode() {
        return getNormalizeValue(10).replace(" ", "");
    }

    public String getConditionalSystem() {
        return getConditionalValue(getNormalizeValue(1));
    }

    public String getConditionalModule() {
        return getConditionalValue(getNormalizeValue(2));
    }

    public String getConditionalSubModule() {
        return getConditionalValue(getNormalizeValue(3));
    }

    public String getConditionalRawCode() {
        return getConditionalValue(getNormalizeValue(4));
    }

    public String getConditionalRawDescription() {
        return getConditionalValue(getNormalizeValue(5));
    }

    public String getConditionalCanonicalCode() {
        return getConditionalValue(getNormalizeValue(6));
    }

    public String getConditionalCanonicalDescription() {
        return getConditionalValue(getNormalizeValue(7));
    }

    public String getConditionalCanonicalType() {
        return getConditionalValue(getNormalizeValue(8));
    }

    public String getConditionalStatus() {
        return getConditionalValue(getNormalizeValue(9));
    }

    public String getConditionalHttpCode() {
        return getConditionalValue(getNormalizeValue(10));
    }

    public String getErrorMessage(){
        return "No se pudo insertar la siguiente traduccion: (ES: " + getSystem() +
                "- MOD: " + getModule() +
                "- SUB_MOD: " + getSubModule() +
                "- RAW_CODE: " + getRawCode() +
                "- CAN_CODE: " + getCanonicalCode() +
                "- CAN_DESC: " + getCanonicalDescription() +
                "- CAN_TYPE: " + getCanonicalType() +
                "- STATUS: " + getStatus() +
                "- HTTP_CODE: " + getHttpCode();
    }
}