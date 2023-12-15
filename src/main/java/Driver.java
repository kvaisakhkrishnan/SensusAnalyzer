import java.io.File;
import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) {
       try{
           String filePath = "/Users/vaisakhkrishnank/IdeaProjects/IndianStatesCensusAnalyser/src/StateCensus.csv";
           System.out.println("Welcome to Indian State Census Analyser");
           Data data = new Data();
           int rowCount = data.readFromCSV(filePath);
           if(rowCount == 37){
               System.out.println("Data Read Succesfully");
           }
           else{
               System.out.println("Data Read Failed");
           }
       }
       catch(InvalidHeader | FileNotFound | NumberFormatException err){
           err.printStackTrace();
       }
    }
}
