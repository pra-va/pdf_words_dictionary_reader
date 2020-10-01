package lt.pra_va;

import lt.pra_va.dazninis.DazninisProcessor;
import lt.pra_va.morfemika.MorfemikaProcessor;

import java.util.ArrayList;
import java.util.List;

public class TypesChecker {
    public static void main(String[] args) {
        List<List<Word>> allWords = new ArrayList<>();
        allWords.add(DazninisProcessor.getWords());
        allWords.add(MorfemikaProcessor.getWords());
        ArrayList<Word> filteredList = FilterAndAppender.getFullList(allWords);
        ArrayList<String> types = new ArrayList<>();
        for (Word word :
                filteredList) {
            if (types.size() == 0) {
                types.add(word.getAntecedent());
            } else {
                boolean matchFound = false;
                for (String type :
                        types) {
                    if (word.getAntecedent().equals(type)) {
                        matchFound = true;
                    }
                }
                if (!matchFound) {
                    types.add(word.getAntecedent());
                }
            }
        }
        System.out.println(types);
    }
}
