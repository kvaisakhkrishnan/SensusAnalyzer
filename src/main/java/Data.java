import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Data {
    ArrayList<SensusData> data;
    Data(){
        this.data = new ArrayList<>();
    }
    void readFromCSV(String filePath){
        System.out.println("Reading Data From CSV File");
        try{
            CSVReader reader = new CSVReader(new FileReader(filePath));
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null){
                data.add(new SensusData(line[1], Integer.parseInt(line[2]), line[3]));
            }
            reader.close();
        }catch(IOException | CsvValidationException error){
            error.printStackTrace();
        }
        System.out.println("No Of Rows Read: " + data.size());

    }
}
