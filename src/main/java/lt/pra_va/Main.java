package lt.pra_va;



import lt.pra_va.dazninis.DazninisProcessor;
import lt.pra_va.morfemika.MorfemikaProcessor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Word>> allWords = new ArrayList<>();
        allWords.add(DazninisProcessor.getWords());
        allWords.add(MorfemikaProcessor.getWords());
        ArrayList<Word> filteredList = FilterAndAppender.getFullList(allWords);
        CsvWriter.write(filteredList);
    }


}
