package projects.Six;

/**
 * Created by jjrobertson on 4/15/2017.
 */
public class Crazy8 {
    String[] mCardSeq;
    String[] mMaxTrick;      //maximum trick subsequence

    public Crazy8(String[] cardSeq) {
        mCardSeq = cardSeq;

    }

    /*
     * generates mMaxSeq, the maximum trick subsequence
     */
    public void findTrickSequence() {
        int[] trick = new int[mCardSeq.length];//memoization array, stores maximum trick length ending at i
        int curMax; //current maximum trick while scanning previously calculated subarray
        int totalMaxIndex; //keeps track of the index of the maximum of all of trick[]
        int[] prev = new int[mCardSeq.length]; //stores index of previous card in maximum trick ending at i

        trick[0] = 1;
        totalMaxIndex = 0;
        prev[0] = 0;
        //generate rest of trick[]
        for (int i = 1; i < trick.length; i++) {
            curMax = 0;
            for (int j = 0; j < i; j++) { //iterate through calculated subarray
                if (trick[j] > curMax) {
                    if (doMatch(mCardSeq[i], mCardSeq[j])) {
                        curMax = trick[j];
                        trick[i] = curMax + 1;
                        prev[i] = j;
                    }
                }
            }
            if(trick[i] > trick[totalMaxIndex])
                totalMaxIndex = i;
        }

        //generate maximum trick subsequence by back-tracing through trick[]
        mMaxTrick = new String[trick[totalMaxIndex]]; //size is the max trick sequence length
        int curPrev = totalMaxIndex;
        for (int i = mMaxTrick.length - 1; i >= 0; i--) {
            mMaxTrick[i] = mCardSeq[curPrev];
            curPrev = prev[curPrev];
        }
    }

    /*
     * iterates mMaxSeq, prints the maximum trick subsequence
     */
    public void printTrickSeqeunce() {
        System.out.println("The length of trick sequence = " + mMaxTrick.length);
        System.out.println("Trick Sequence");
        for (int i = 0; i < mMaxTrick.length; i++) {
            System.out.print(mMaxTrick[i] + " ");
        }
        System.out.println();
    }

    /*
     * returns true if the cards match, false if they don't
     */
    private boolean doMatch (String ci, String cj) {
        char irank = ci.charAt(0);
        char isuit = ci.charAt(1);
        char jrank = cj.charAt(0);
        char jsuit = cj.charAt(1);

        if(irank == jrank)
            return true;
        if(isuit == jsuit)
            return true;
        if(irank == '8' || jrank == '8')
            return true;
        return false;
    }
}
