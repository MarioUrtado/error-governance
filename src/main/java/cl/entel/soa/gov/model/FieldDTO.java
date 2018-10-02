package cl.entel.soa.gov.model;

public class FieldDTO {

    private String entity;

    private String field;

    public FieldDTO(String entity, String field) {
        this.entity = entity;
        this.field = field;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getKey(){
        return getEntity() + "@" + getField();
    }
}
