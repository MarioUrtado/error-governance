package cl.entel.soa.gov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

    public static void main (String[] args){
        try{

            ApplicationContext app = SpringApplication.run(App.class, args);
            Executer executer = app.getBean(Executer.class);
            executer.buildCanonical();
            executer.buildMapping();


        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
