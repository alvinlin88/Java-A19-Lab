/**
 *
 * @author Alvin Lin
 * @period #3
 */

/**
 * Word Class holding the Word Object
 */
public class Word {

    private int count;
    private String word;

    /**
     * Default Constructor declaring the instance variables
     */
    public Word(){
        word = "";
        count = 0;
    }

    /**
     * Parameter Constructor setting word to theWord and count to 1
     * @param theWord string the Word object holds
     */
    public Word(String theWord){
        word = theWord;
        count = 1;
    }

    /**
     * Getter Method to return count
     * @return count of Word
     */
    public int getCount() {
        return count;
    }

    /**
     * Setter method to set count
     * @param count count of Word
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Getter method to access word
     * @return the word string held in Word
     */
    public String getWord() {
        return word;
    }

    /**
     * Setter method to set word
     * @param word the word string held in Word
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Method to increment count of the Word Object by 1
     */
    public void incrementCount(){
        count++;
    }

    /**
     * Method to decrease count of the Word Object by 1
     */
    public void decrementCount(){
        count--;
    }

    /**
     * Method to compare the strings of 2 word objects
     * @param w 2nd word object to be compared to
     * @return true if the 2 words are the same, false otherwise
     */
    public boolean compareTo(Word w){

        if(word.compareTo(w.getWord()) == 0){
            return true;
        }
        else{
            return false;
        }
    }
}