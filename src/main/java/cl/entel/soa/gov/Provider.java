package cl.entel.soa.gov;

import cl.entel.soa.gov.freemaker.Factory;
import cl.entel.soa.gov.model.SystemDTO;
import cl.entel.soa.gov.parser.Parser;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class Provider {

    @Autowired
    private Factory factory;

    @Autowired
    private Parser parser;

    private List<SystemDTO> providers;

    public Provider() {
    }

    public Provider(String url, String sheetName){
        try{
            Sheet sheet = parser.readSheed(url, sheetName);
            Iterable<Row> iterable = () -> sheet.rowIterator();
            providers = StreamSupport.stream(iterable.spliterator(), false)
                    .filter(row ->row != null)
                    .map(row -> new SystemDTO(row))
                    .collect(Collectors.toList());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void build(){
        try {
            Map<String, Object> mapCanonicalErrors = new HashMap<String, Object>();
            mapCanonicalErrors.put("mappings", providers);
            factory.generate("script", "ESB_CANONICAL_ERROR", ("/Users/mariopaulinourtadomedrano/Projects/ws-automation/Workspace/test/INSERT_ESB_CANONICAL_ERROR.sql"), mapCanonicalErrors);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SystemDTO> getProviders() {
        return providers;
    }

    public void setProviders(List<SystemDTO> providers) {
        this.providers = providers;
    }
}
