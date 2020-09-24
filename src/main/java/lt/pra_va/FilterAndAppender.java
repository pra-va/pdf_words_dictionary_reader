package lt.pra_va;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterAndAppender {

    public static ArrayList<Word> getFullList (List<List<Word>> wordsList) {
        ArrayList<Word> returnList = new ArrayList<>();
        for (int i = 0; i < wordsList.size(); i++) {
            returnList.addAll(wordsList.get(i));
        }
        Collections.sort(returnList);
        return removeDuplicates(returnList);
    }

    private static ArrayList<Word> removeDuplicates(ArrayList<Word> wordsList) {
        ArrayList<Integer> removeList = new ArrayList<>();
        String currentlyChecking = "";
        for (int i = 0; i < wordsList.size() - 1; i++) {
            if (!wordsList.get(i + 1).getWord().equals(currentlyChecking)) {
                currentlyChecking = wordsList.get(i + 1).getWord();
            } else {
                removeList.add(i + 1);
            }
        }
        for (Integer index: removeList) {
            wordsList.remove(index);
        }
        ArrayList<Word> filteredList = new ArrayList<>();
        int removeListIndex = 0;
        for (int i = 0; i < wordsList.size(); i++) {
            if (removeList.get(removeListIndex) == i) {
                if (removeListIndex < removeList.size()) {
                    removeListIndex++;
                }
                continue;
            }
            filteredList.add(wordsList.get(i));
        }
        return filteredList;
    }
}
