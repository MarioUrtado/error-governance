package cl.entel.soa.gov.build;

import cl.entel.soa.gov.freemaker.Factory;
import cl.entel.soa.gov.model.CanonicalDTO;
import cl.entel.soa.gov.model.CanonicalErrorRowDTO;
import cl.entel.soa.gov.parser.Parser;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class CanonicalError {

    @Value("${canonical.output}")
    private String outputPath;

    @Value("${canonical.input}")
    private String input;

    @Value("${canonical.input.sheet.name}")
    private String sheetName;

    @Autowired
    private Parser parser;

    @Autowired
    private Factory factory;

    private List<CanonicalDTO> canonicalErrors;

    public CanonicalError(){
    }

    @PostConstruct
    public void init(){
        try {
            Sheet sheet = parser.readSheed(input, sheetName);
            Iterable<Row> iterable = () -> sheet.rowIterator();
            canonicalErrors = StreamSupport.stream(iterable.spliterator(), false)
                    .filter(row -> row != null)
                    .map(row -> new CanonicalErrorRowDTO(row))
                    .map(dto -> new CanonicalDTO(dto))
                    .filter(x -> !x.getCode().equals("CANONICAL_ERROR_CODE"))
                    .collect(Collectors.toList());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void build() {
        try {
            Map<String, Object> mapCanonicalErrors = new HashMap<String, Object>();
            mapCanonicalErrors.put("mappings", canonicalErrors);
            factory.generate("script", "ESB_CANONICAL_ERROR", (outputPath+"/INSERT_ESB_CANONICAL_ERROR.sql"), mapCanonicalErrors);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CanonicalDTO> getCanonicalErrors() {
        return canonicalErrors;
    }
}
