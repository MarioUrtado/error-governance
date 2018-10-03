package cl.entel.soa.gov.build;

import cl.entel.soa.gov.freemaker.Factory;
import cl.entel.soa.gov.model.FieldDTO;
import cl.entel.soa.gov.model.MappingRowDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
public class ReferenceData {

    @Autowired
    private Factory factory;

    @Value("${reference.data.output}")
    private String outputPath;

    public ReferenceData(){
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public void build(Workbook book){
        Sheet sheet = book.getSheet("ESB_MAPPING");
        Iterable<Row> iterable = () -> sheet.rowIterator();
        List<MappingRowDTO> mappings = StreamSupport.stream(iterable.spliterator(), false)
                .map(x -> new MappingRowDTO(x))
                .collect(Collectors.toList());
        Map<String, Object> mapCanonicalErrors = new HashMap<String, Object>();
        mapCanonicalErrors.put("mappings", mappings);
        factory.generate("script", "ESB_MAPPING", (outputPath + "/INSERT_ESB_MAPPING.sql"), mapCanonicalErrors);
    }

    private void buildEntities(List<MappingRowDTO> mappings){
        List<String> entities = mappings
                .stream()
                .map(x -> x.getEntity())
                .distinct()
                .collect(Collectors.toList());
        Map<String, Object> entitiesMap = new HashMap<String, Object>();
        entitiesMap.put("entities", entities);
        factory.generate("script", "ESB_CDM_ENTITY", (outputPath + "/INSERT_ESB_CDM_ENTITY.sql"), entitiesMap);
    }

    private void buildFields(List<MappingRowDTO> mappings){
        List<FieldDTO> fields = mappings
                .stream()
                .map(x -> new FieldDTO(x.getEntity(), x.getField()))
                .filter(distinctByKey(FieldDTO::getKey))
                .collect(Collectors.toList());
        Map<String, Object> mapFields = new HashMap<String, Object>();
        mapFields.put("entities", fields);
        factory.generate("script", "ESB_CDM_FIELD", (outputPath + "/INSERT_ESB_CDM_FIELD.sql"), mapFields);
    }
}
