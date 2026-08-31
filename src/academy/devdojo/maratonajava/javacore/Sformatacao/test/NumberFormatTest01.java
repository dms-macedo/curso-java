package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest01 {
    public static void main(String[] args) {
        Locale localeUS = Locale.US;
        Locale localeBR = new Locale("pt", "br");
        Locale localeJPN = Locale.JAPAN;
        Locale localeIT = Locale.ITALY;

        NumberFormat[] nfa = new NumberFormat[4];
        nfa[0] = NumberFormat.getInstance(localeUS);
        nfa[1] = NumberFormat.getInstance(localeBR);
        nfa[2] = NumberFormat.getInstance(localeIT);
        nfa[3] = NumberFormat.getInstance(localeJPN);

        double number = 1_000_000.24;
        for (NumberFormat numberFormat : nfa) {
            System.out.println(numberFormat.getCurrency() + " " + numberFormat.format(number));
        }

    }
}
