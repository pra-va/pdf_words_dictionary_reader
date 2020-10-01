package lt.pra_va;

import org.h2.tools.Csv;
import org.h2.tools.SimpleResultSet;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class CsvWriter {

    public static void write(List<Word> wordsList) {
        SimpleResultSet rsWords = new SimpleResultSet();
        rsWords.addColumn("WORD", Types.VARCHAR, 255, 0);
        rsWords.addColumn("TYPE_NR", Types.VARCHAR, 255, 0);

        SimpleResultSet rsTypes = new SimpleResultSet();
        rsTypes.addColumn("TYPE_NR", Types.VARCHAR, 255, 0);
        rsTypes.addColumn("TYPE", Types.VARCHAR, 255,0);
        rsTypes.addRow("1", getType("tikr.dkt."));
        rsTypes.addRow("2", getType("akronim."));
        rsTypes.addRow("3", getType("jst."));
        rsTypes.addRow("4", getType("sutr."));
        rsTypes.addRow("5", getType("dkt."));
        rsTypes.addRow("6", getType("sktv."));
        rsTypes.addRow("7", getType("prv."));
        rsTypes.addRow("8", getType("bdv."));
        rsTypes.addRow("9", getType("vksm."));
        rsTypes.addRow("10", getType("prl."));
        rsTypes.addRow("11", getType("dll."));
        rsTypes.addRow("12", getType("jng."));

        for (Word word :
                wordsList) {
            if (!word.getAntecedent().equals("rom.sk.")) {
                rsWords.addRow(word.getWord(), getNumber(word.getAntecedent()));
            }
        }
        try {
            new Csv().write("words.csv", rsWords, null);
            new Csv().write("types.csv", rsTypes, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getType(String type) {
        switch (type) {
            case "tikr.dkt.":
                return "Tikrinis daiktavardis";
            case "akronim.":
                return "Akronimas";
            case "jst.":
                return "Jaustukas";
            case "sutr.":
                return "Sutrumpinimas";
            case "dkt.":
                return "Daiktavardis";
            case "sktv.":
                return "Skaitvardis";
            case "prv.":
                return "Prieveiksmis";
            case "bdv.":
                return "Būdvardis";
            case "vksm.":
                return "Veiksmažodis";
            case "prl.":
                return "Prielinksnis";
            case "dll.":
                return "Dalelytė";
            case "jng.":
                return "Jungtukas";
            case "rom.sk.":
                return "Romėniškas skaičius";
            default:
                return "NULL";
        }
    }

    public static String getNumber(String type) {
        switch (type) {
            case "tikr.dkt.":
                return "1";
            case "akronim.":
                return "2";
            case "jst.":
                return "3";
            case "sutr.":
                return "4";
            case "dkt.":
                return "5";
            case "sktv.":
                return "6";
            case "prv.":
                return "7";
            case "bdv.":
                return "8";
            case "vksm.":
                return "9";
            case "prl.":
                return "10";
            case "dll.":
                return "11";
            case "jng.":
                return "12";
            case "rom.sk.":
                return "13";
            default:
                return "0";
        }
    }
}
