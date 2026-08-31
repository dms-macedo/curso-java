package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest01 {
    public static void main(String[] args) {
        Locale localeItaly = new Locale("it", "IT");
        Locale localeCH = new Locale("it", "CH");
        Locale localeIndia = new Locale("hi", "IN");
        Locale localeJapao = new Locale("ja", "JP");
        Locale localeHolanda = new Locale("nl", "NL");

        Calendar cl = Calendar.getInstance();
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, localeCH);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, localeIndia);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, localeJapao);
        DateFormat df5 = DateFormat.getDateInstance(DateFormat.FULL, localeHolanda);

        System.out.println("Italy: " + df1.format(cl.getTime()));
        System.out.println("Suiça: " + df2.format(cl.getTime()));
        System.out.println("India: " + df3.format(cl.getTime()));
        System.out.println("Japão: " + df4.format(cl.getTime()));
        System.out.println("Holanda: " + df5.format(cl.getTime()));

        System.out.println(localeItaly.getDisplayCountry(localeJapao));
        System.out.println(localeCH.getDisplayCountry(localeItaly));
    }
}
