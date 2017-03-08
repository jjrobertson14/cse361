package projects.Three;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by 1234r_000 on 2/28/2017.
 */
public class TextAnalyzer {
    private int numWords;
    private String fileName;
    private File iFile;
    private Vector<String> inputStrList;
    private String reWordPattern; //matches words
    private String reDelim; //used to override the Scanner delimiter
    private HashMap<String,Integer> wordMap;

    /*
     * constructor, tokens are hashed with the call to hashTokens
     */
    public TextAnalyzer(String fd) {
        //finds absolute file path by searching the classpath for it
        URL url = getClass().getResource(fd);
        fileName = url.getPath();
        iFile = new File(fileName);
        inputStrList = new Vector<>();

        reWordPattern = "([\\w\\-]*)+"; //any amount of words
        reDelim = "(?!\\-\\w)[\\s\\p{Punct}]+"; //sequence of spaces and/or punctuation except a single "-"
        inputStrList = Tokenize(iFile);
        wordMap = hashTokens(inputStrList);
    }

    /*
     *tokenize input file f, put tokens into inputStrList
     */
    private Vector<String> Tokenize (File f) {
        Vector<String> wordList = new Vector<>();
        Pattern ptWordPattern = Pattern.compile(reWordPattern);
        Pattern ptDelim = Pattern.compile(reDelim);

        try {
            Scanner reader = new Scanner(f);
            reader.useDelimiter(ptDelim);
            while (reader.hasNext(ptWordPattern)) {
                wordList.add(reader.next(ptWordPattern));
            }
        }
        catch (FileNotFoundException ex) {System.err.print(f.exists());}

        return wordList;
    }

    /*
     * generates and returns hash map from the vector of word tokens
     */
    private HashMap<String,Integer> hashTokens (Vector<String> wordList) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(String word : wordList) {
            if(hm.containsKey(word)) {
                hm.put(word,hm.get(word) + 1);
            }
            else {
                hm.put(word, new Integer(1));
            }
        }
        
        numWords = hm.size();
        return hm;
    }

    /*
     * the priority queues will be populated with WordNodes, this easily allows sorting to be done by key or value
     */
    private class WordNode {
        private String key; //word
        private int value;  //freq

        public WordNode(String k, int v) {
            key = k;
            value = v;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /*
     * generates priority queue of HashMap elements sorted lexicographically by key and prints each key,value pair
     */
    public void LexiSort() {
//        KeyValuePQ<String,Integer> pqLex = new KeyValuePQ<>();
        PriorityQueue<WordNode> pqLexi = new PriorityQueue<WordNode>(new Comparator<WordNode>() {
            @Override
            public int compare(WordNode o1, WordNode o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        HashMap<String,Integer> tmpWordMap = wordMap; // to not remove elements from wordMap when iterating over it
        Set set = tmpWordMap.entrySet();

        // Get an iterator
        Iterator<Map.Entry> hashIter = set.iterator();

        // load WordNodes into PriorityQueue
        while(hashIter.hasNext()) {
            Map.Entry me = hashIter.next();
            pqLexi.add(new WordNode(me.getKey().toString(), (int)me.getValue()));
        }

        WordNode root;
        while ((root = pqLexi.poll()) != null) {
            System.out.print(root.getKey() + ": ");
            System.out.println(root.getValue());
        }
    }

    /*
     * generates priority queue of HashMap elements sorted by frequency (value) and prints each key,value pair
     */
    public void FreqSort() {
        //        KeyValuePQ<String,Integer> pqLex = new KeyValuePQ<>();
        PriorityQueue<WordNode> pqFreq = new PriorityQueue<WordNode>(new Comparator<WordNode>() {
            @Override
            public int compare(WordNode o1, WordNode o2) {
                if (o1.getValue() > o2.getValue()) return  -1;
                else if (o1.getValue() == o2.getValue()) return  0;
                else return  1;
            }
        });

        HashMap<String,Integer> tmpWordMap = wordMap; // to not remove elements from wordMap when iterating over it
        Set set = tmpWordMap.entrySet();

        // Get an iterator
        Iterator<Map.Entry> hashIter = set.iterator();

        // load WordNodes into PriorityQueue
        while(hashIter.hasNext()) {
            Map.Entry me = hashIter.next();
            pqFreq.add(new WordNode(me.getKey().toString(), (int)me.getValue()));
        }

        WordNode root;
        while ((root = pqFreq.poll()) != null) {
            System.out.print(root.getKey() + ": ");
            System.out.println(root.getValue());
        }
    }

    //getter, but main method doesn't call it as getWordCount
    public int wordCount() {
        return numWords;
    }
}
