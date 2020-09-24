package lt.pra_va;

public class Word implements Comparable<Word> {

    private String word = "";
    private String antecedent = "";

    public Word() {
    }

    public Word(String word, String antecedent) {
        this.word = word;
        this.antecedent = antecedent;
    }

    public String getWord() {
        return word;
    }

    public String getAntecedent() {
        return antecedent;
    }

    public void appendToAntecedent(String antecedent) {
        this.antecedent += antecedent;
    }

    public void appendToWord(String word) {
        this.word += word;
    }

    @Override
    public String toString() {
        return this.word + " - " + this.antecedent;
    }

    @Override
    public int compareTo(Word o) {
        return this.word.compareTo(o.getWord());
    }
}
