import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StateSensusTest {
    @Test
    public void testCSVFileRead(){
        try{
            Data data = new Data();
            int expectedRowCount = 37;
            int rowCount = data.readFromCSV("/Users/vaisakhkrishnank/IdeaProjects/IndianStatesCensusAnalyser/src/StateCensus.csv");
            assertEquals(expectedRowCount, rowCount);
        }
        catch(InvalidHeader | FileNotFound | NumberFormatException err){
            err.printStackTrace();
        }
    }

    @Test
    public void invalidFileInput(){
        try{
            Data data = new Data();
            int expectedRowCount = 37;
            int rowCount = data.readFromCSV("/Users/vaisakhkrishnank/IdeaProjects/IndianStatesCensusAnalyser/src/noFile.csv");
            fail("File Not Found");
        } catch(InvalidHeader | FileNotFound | NumberFormatException err){
            err.printStackTrace();
        }

    }

    @Test
    public void invalidInputData(){
      try{
          Data data = new Data();
          int expectedRowCount = 37;
          int rowCount = data.readFromCSV("/Users/vaisakhkrishnank/IdeaProjects/IndianStatesCensusAnalyser/src/StateCensus2.csv");
          fail("Invalid Data");
      }catch(InvalidHeader | FileNotFound | NumberFormatException err){
          err.printStackTrace();
      }
    }

    @Test
    public void invalidHeaderData(){
        try{
            Data data = new Data();
            int expectedRowCount = 37;
            int rowCount = data.readFromCSV("/Users/vaisakhkrishnank/IdeaProjects/IndianStatesCensusAnalyser/src/StateCensus3.csv");
            fail("Invalid Header");
        }catch(InvalidHeader | FileNotFound | NumberFormatException err){
            err.printStackTrace();
        }
    }


}
