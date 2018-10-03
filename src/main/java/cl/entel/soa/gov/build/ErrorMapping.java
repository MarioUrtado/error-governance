package cl.entel.soa.gov.build;

import cl.entel.soa.gov.freemaker.Factory;
import cl.entel.soa.gov.model.CanonicalDTO;
import cl.entel.soa.gov.model.CanonicalErrorRowDTO;
import cl.entel.soa.gov.model.ErrorMappingRowDTO;
import cl.entel.soa.gov.model.TargetDTO;
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
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ErrorMapping {

    @Autowired
    private Parser parser;

    @Autowired
    private Factory factory;

    @Value("${mapping.output}")
    private String outputPath;

    @Value("${mapping.input}")
    private String input;

    @Value("${mapping.input.sheet.name}")
    private String sheetName;

    private List<ErrorMappingRowDTO> mappings;

    private List<TargetDTO> targets;

    public ErrorMapping(){
    }

    @PostConstruct
    public void init(){
        try {
            Sheet sheet = parser.readSheed(input, sheetName);
            Iterable<Row> iterable = () -> sheet.rowIterator();
            mappings = StreamSupport.stream(iterable.spliterator(), false)
                    .filter(row ->row != null)
                    .map(row -> new ErrorMappingRowDTO(row))
                    .collect(Collectors.toList());

            targets = mappings
                    .stream()
                    .map(x -> new TargetDTO(x.getSystem(), x.getModule(), x.getSubModule()))
                    .filter(distinctByKey(TargetDTO::getName))
                    .filter( x -> !x.getSubModule().equals("SYSTEM CODE CODE"))
                    .collect(Collectors.toList());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public void build(){
        try{
            for (TargetDTO target: targets) {
                List<ErrorMappingRowDTO> maps = mappings
                        .stream()
                        .filter(x -> x.getSystem().equals(target.getSystem()) && x.getModule().equals(target.getModule()) && x.getSubModule().equals(target.getSubModule()))
                        .collect(Collectors.toList());
                Map<String, Object> mapppingsByErrorSource = new HashMap<String,Object >();
                mapppingsByErrorSource.put("mappings", maps);
                factory.generate("script","ESB_ERROR_MAPPING" , (outputPath + "/" + target.getName() + ".sql" ) , mapppingsByErrorSource);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<ErrorMappingRowDTO> getMappings() {
        return mappings;
    }

    public List<TargetDTO> getTargets() {
        return targets;
    }
}
