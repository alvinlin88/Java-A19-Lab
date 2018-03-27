/**
 *
 * @author Alvin Lin
 * @period #3
 */

/**
 * Driver Class to test the program
 */
public class CountWordsDriver {

    /**
     * Main method to test the program
     * @param args main method
     */
    public static void main(String[] args) {
        CountWords test = new CountWords("test.txt");
        test.loadFile();
        test.totalWords();
        test.sortList();
        test.printStats();
    }
}
