package cl.entel.soa.gov.freemaker;


import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Map;

@Component
public class Factory {

    private Logger logger = LoggerFactory.getLogger(Factory.class);

    public void generate( String relativePath, String templateName, String targetFile, Map<String, Object> map ){
        try{
            Configuration configuration = ConfigurationFactory.getInstance();
            Template template = configuration.getTemplate("/"+ relativePath + "/"+ templateName+ ".ftl");
            Writer fileWriter = new FileWriter(new File(targetFile));
            template.process(map, fileWriter);
            fileWriter.close();
            logger.info("Write " + targetFile + " from template " + relativePath + "/" + templateName + ".ftl");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
