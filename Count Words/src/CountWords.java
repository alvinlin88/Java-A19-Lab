import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 *
 * @author Alvin Lin
 * @period #3
 */

/**
 * Class to count and print the words by their count
 */
public class CountWords
{
    private ArrayList<Word> words = new ArrayList<Word>();
    private String fileName;

    /**
     * Parameter constructor setting fileName to the name of the text file
     * @param fileName name of text file with the words
     */
    public CountWords(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Method to read the data from the text file and store it in the ArrayList words
     */
    public void loadFile(){
                 Scanner in;

                try{
                    in = new Scanner(new File(fileName));
                    while(in.hasNext()){
                        String temp = in.next().toLowerCase();
                        Word w = new Word(temp);
                        if(getIndexByname(w.getWord()) == -1){
                            words.add(w);
                        }
                        else{
                            int incrementWord = getIndexByname(w.getWord());
                            words.get(incrementWord).incrementCount();
                        }

            }
        }
        catch(IOException i){
            System.out.println("Error: " + i.getMessage());
        }
    }

    /**
     * Method to return the index of a repeating word
     * @param pName word that is being checked for duplicates
     * @return index of the duplicate word if there is in fact a duplicate, -1 otherwise
     */
    public int getIndexByname(String pName) {
        for(int i = 0; i<words.size(); i++){
            Word w = words.get(i);
            if(pName.equals(w.getWord())){
                return i;
            }
        }
        return -1;
    }

    /**
     * Method to return the total words in the text file, including duplicates
     * @return number of total words
     */
    public int totalWords(){
        Scanner in;
        ArrayList<Word> totalWords = new ArrayList<Word>();

        try{
            in = new Scanner(new File(fileName));
            while(in.hasNext()){
                String temp = in.next();
                Word w = new Word(temp);
                    totalWords.add(w);
            }
        }
        catch(IOException i){
            System.out.println("Error: " + i.getMessage());
        }

        return totalWords.size();
    }

    /**
     * Method to sort the list of words by their count
     */
    public void sortList(){
        Collections.sort(words, Comparator.comparing(Word::getCount));
        Collections.reverse(words);
    }

    /**
     * Method to print the stats of the text file as well as the top 30 words by count
     */
    public void printStats(){

        System.out.println("File: " + fileName);
        System.out.println("Total number of unique words used in the file: " + words.size());
        System.out.println("Total number of words in file: " + totalWords());
        System.out.println("Top 30 words are:");

        int count = words.size();

        if(words.size() > 30){
            count = 30;
        }

        for(int i=0; i<count; i++){
            System.out.println((i) + "    " + words.get(i).getCount() + "      " + words.get(i).getWord());
        }


    }
}
	
