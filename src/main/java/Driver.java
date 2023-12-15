public class Driver {
    public static void main(String[] args) {
        String filePath = "/Users/vaisakhkrishnank/IdeaProjects/IndianStatesCensusAnalyser/src/StateCensus.csv";
        System.out.println("Welcome to Indian State Census Analyser");
        Data data = new Data();
        data.readFromCSV(filePath);
    }
}
