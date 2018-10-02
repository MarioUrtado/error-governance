package cl.entel.soa.gov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Executer {

    @Autowired
    private CanonicalError canonicalError;

    @Autowired
    private ErrorMapping errorMapping;

    public Executer(){}

    public void buildCanonical(){
        canonicalError.build();
    }

    public void buildMapping(){
        errorMapping.build();
    }
}
