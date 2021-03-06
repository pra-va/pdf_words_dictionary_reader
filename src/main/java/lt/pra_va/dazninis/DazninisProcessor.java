package lt.pra_va.dazninis;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import lt.pra_va.MyPdfReader;
import lt.pra_va.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class DazninisProcessor {
    public static ArrayList<Word> getWords() {
        String[] text = MyPdfReader.read("Dazninis_zodynas.pdf", 10, 464)
                .split("\\s[0-9]{1,5}[.]");
        ArrayList<Word> wordsList = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            String[] processedLine = processDazninisLine(text[i]);
            if (processedLine[0] != null && processedLine[1] != null &&
                !processedLine[0].equals("") && !processedLine[0].matches("[0-9]*[-][č]?[a-zA-Z]*") &&
                !processedLine[0].matches("[A-Z]*")) {
                wordsList.add(new Word(processedLine[0], processedLine[1]));
            }
        }
        return wordsList;
    }

    public static String[] processDazninisLine(String line) {
        String[] lineArray = line.split(" ");
        String[] returnArray = new String[2];
        StringBuilder wordsBuilder = new StringBuilder();
        StringBuilder antecedentBuilder = new StringBuilder();
        boolean isInsideAntecedent = false;
        for (String word: lineArray) {
            if (word.matches("[(]?[A-Za-z]*[.][)]?")) {
                isInsideAntecedent = true;
                antecedentBuilder.append(word);
            } else if (!word.matches("[(]([A-Za-z]*[.]){1,3}[)]") && !isInsideAntecedent) {
                wordsBuilder.append(word);
            } else {
                returnArray[0] = wordsBuilder.toString();
                returnArray[1] = antecedentBuilder.toString()
                        .replace("(","").replace(")", "");
                break;
            }
        }
        return returnArray;
    }
}
