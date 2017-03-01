package projects.Three;

/**
 * Created by singh on 2/22/17.
 */
public class Main {
    // Main program

    public static void main(String[] args) {

        TextAnalyzer  txtA = new TextAnalyzer("input.txt");

        System.out.println ("Number of words found = " + txtA.wordCount());
        System.out.println ("Word and frequencies sorted by word frequencies");
        txtA.FreqSort();
        System.out.println ("Word and frequencies sorted lexicographically by words");
        txtA.LexiSort();
    }
}