package cl.entel.soa.gov.model;

public class TargetDTO {

    private String system;

    private String module;

    private String subModule;

    public TargetDTO(String system, String module, String subModule) {
        this.system = system;
        this.module = module;
        this.subModule = subModule;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getSubModule() {
        return subModule;
    }

    public void setSubModule(String subModule) {
        this.subModule = subModule;
    }

    public String getName(){
        if (getSubModule().equals("") && getModule().equals("")){
            return getSystem();
        } else if (!getModule().equals("") && getSubModule().equals("")){
            return getSystem() + "_" + getModule();
        } else if (!getModule().equals("") && !getSubModule().equals("")) {
            return getSystem() + "_" + getModule() + "_" + getSubModule();
        }
        return getSystem() + "_UNIDENTIFIED.sql";
    }

}
