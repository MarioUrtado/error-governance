package cl.entel.soa.gov.http;

import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

@Component
public class Downloader {

    @Value("${credentials.confluence.username}")
    public String username;

    @Value("${credentials.confluence.password}")
    public String password;

    public static Logger logger = LoggerFactory.getLogger(Downloader.class);

    public Downloader(){

    }

    public InputStream download(String uri){
        InputStream inputStream = null;
        try {
            URL url = new URL(uri);

            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestProperty("Authorization", "Basic " + new String(Base64.getEncoder().encode(( username + ":" + password).getBytes())));
            httpConn.connect();
            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {

                // opens input stream from the HTTP connection
                byte[] byteArray = IOUtils.toByteArray(httpConn.getInputStream());
                inputStream  = new ByteArrayInputStream(byteArray);
                httpConn.disconnect();
                logger.info("File downloaded: " + uri);
            } else {
                logger.error("URL: " + uri + " - STATUS: " + httpConn.getResponseCode() + " " + httpConn.getResponseMessage());
            }
            httpConn.disconnect();

        } catch (Exception e){
            e.printStackTrace();
        }
        return inputStream;
    }

}
