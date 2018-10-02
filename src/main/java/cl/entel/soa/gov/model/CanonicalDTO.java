package cl.entel.soa.gov.model;

public class CanonicalDTO {

    private String code;

    private String type;

    private String description;

    public CanonicalDTO(CanonicalErrorRowDTO row){
        this.code = row.getCode();
        this.type = row.getType();
        this.description = row.getDescription();
    }

    public CanonicalDTO(String code, String type, String description) {
        this.code = code;
        this.type = type;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
