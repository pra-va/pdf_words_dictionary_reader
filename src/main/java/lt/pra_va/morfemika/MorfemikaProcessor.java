package lt.pra_va.morfemika;


import lt.pra_va.MyPdfReader;
import lt.pra_va.Word;

import java.util.ArrayList;

public class MorfemikaProcessor {
    public static ArrayList<Word> getWords() {
        String[] text = MyPdfReader.read("DazI.pdf", 9, 801)
                .split("\n");
        ArrayList<Word> wordsList = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            String[] lineArray = text[i].split(" ");
            if (lineArray.length > 4 && lineArray[4].equals("dkt.")) {
                wordsList.add(new Word(lineArray[3].replace(";", ""), lineArray[4]));
            }
        }
        return wordsList;
    }
}
