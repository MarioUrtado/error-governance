package cl.entel.soa.gov.parser;

import cl.entel.soa.gov.http.Downloader;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Component
public class Parser {

    @Autowired
    private Downloader downloader;

    public Workbook read(File file) throws Exception {
        return this.read(new FileInputStream(file));
    }

    public Workbook read(String url) throws Exception{
        InputStream inputStream = this.downloader.download(url);
        return this.read(inputStream);
    }

    public Workbook read(InputStream inputStream) throws Exception{
        Workbook workbook = new XSSFWorkbook(inputStream);
        return workbook;
    }

    public Workbook parseExcel(String filepath)throws Exception{
        return read(filepath);
    }

    public Sheet readSheed(String filename, String sheetName) throws Exception {
        Workbook book = parseExcel(filename);
        Sheet sheet = book.getSheet(sheetName);
        return sheet;
    }

}
