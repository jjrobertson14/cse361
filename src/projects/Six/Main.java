package projects.Six;

/**
 * Created by jjrobertson on 4/15/2017.
 */
public class Main {
    public static void main(String[] args) {
        String[]   ranks = {"1", "2", "3", "4", "5", "6", "7",
                "8", "9", "J", "Q", "K", "A"};
        String[]   suits = {"C", "S", "H", "D"};

        int         seqLength   =   Integer.parseInt(args[0]);
        String[]    cardSeq     =   new String[seqLength];

        int         cntCards = ranks.length;
        int         cntSuite = suits.length;

        for (int i = 0; i < seqLength; i++)
        {
            // generate the first random number

            int rand1 = (int)(Math.random()*cntCards);
            int rand2 = (int)(Math.random()*cntSuite);

            cardSeq[i] = ranks[rand1] + suits[rand2];

        }

        // Print card cardSeq

        System.out.println ("Random Card Sequence of length " + seqLength);
        for (int i = 0; i < cardSeq.length; i++)
            System.out.print (cardSeq[i] + " ");
        System.out.println ();

        // Create Card Sequence

        Crazy8  crazy8Seq = new Crazy8 (cardSeq);
        crazy8Seq.findTrickSequence();
        crazy8Seq.printTrickSeqeunce();

    }
}
