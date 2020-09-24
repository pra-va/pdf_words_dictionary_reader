package lt.pra_va;



import lt.pra_va.dazninis.DazninisProcessor;
import lt.pra_va.morfemika.MorfemikaProcessor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Word>> wordsLists = new ArrayList<>();
        wordsLists.add(DazninisProcessor.getWords());
        wordsLists.add(MorfemikaProcessor.getWords());
        FilterAndAppender.getFullList(wordsLists);
    }


}
