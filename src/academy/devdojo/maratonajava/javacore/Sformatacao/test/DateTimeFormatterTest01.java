package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterTest01 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        LocalDate p1 = LocalDate.parse("20260908", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate p2 = LocalDate.parse("2026-09-08", DateTimeFormatter.ISO_DATE);
        LocalDate p3 = LocalDate.parse("2026-09-08", DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        String s4 = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(s4);

        LocalDateTime p4 = LocalDateTime.parse("2026-09-08T08:33:41.880263297", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(p4);

        DateTimeFormatter patternBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedBR = LocalDate.now().format(patternBR);

        System.out.println(formattedBR);

        LocalDate p5 = LocalDate.parse("08/09/2026", patternBR);
        System.out.println(p5);

        DateTimeFormatter formatterBR2 = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy", Locale.getDefault());
        String s5 = LocalDate.now().format(formatterBR2);
        System.out.println(s5);
    }
}
