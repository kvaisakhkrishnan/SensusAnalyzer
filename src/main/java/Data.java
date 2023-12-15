import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Data {
    ArrayList<SensusData> data;
    Data(){
        this.data = new ArrayList<>();
    }
    int readFromCSV(String filePath) throws InvalidHeader, FileNotFound, NumberFormatException{
        File file = new File(filePath);
        if(!file.exists()){
            throw new FileNotFound();
        }
        System.out.println("Reading Data From CSV File");
        try{
            CSVReader reader = new CSVReader(new FileReader(filePath));
            String[] line;
            String header[] = reader.readNext();
            if(header[0].equals("SrNo")){
                if(header[1].equals("StateName")){
                    if(header[2].equals("TIN")){
                        if(header[3].equals("StateCode")){

                        }
                        else{
                            throw new InvalidHeader();
                        }
                    }
                    else{
                        throw new InvalidHeader();
                    }
                }
                else{
                    throw new InvalidHeader();
                }
            }
            else{
                throw new InvalidHeader();
            }
            while ((line = reader.readNext()) != null){
                Integer.parseInt(line[2]);
                data.add(new SensusData(line[1], Integer.parseInt(line[2]), line[3]));
            }
            reader.close();
        }catch(IOException | CsvValidationException error){
            error.printStackTrace();
        }
        System.out.println("No Of Rows Read: " + data.size());
        return data.size();

    }
}
