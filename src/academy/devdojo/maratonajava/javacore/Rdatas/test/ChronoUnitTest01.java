package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest01 {
    public static void main(String[] args) {
        LocalDateTime aniversario = LocalDateTime.of(2010, Month.APRIL, 27, 18, 30, 0);
        LocalDateTime now = LocalDateTime.now();

        System.out.println(ChronoUnit.DAYS.between(aniversario, now));
        System.out.println(ChronoUnit.WEEKS.between(aniversario, now));
        System.out.println(ChronoUnit.MONTHS.between(aniversario, now));
        System.out.println(ChronoUnit.YEARS.between(aniversario, now));
        System.out.println(ChronoUnit.HOURS.between(aniversario, now));
        System.out.println(ChronoUnit.MINUTES.between(aniversario, now));
        System.out.println(ChronoUnit.SECONDS.between(aniversario, now));
        System.out.println(ChronoUnit.MILLIS.between(aniversario, now));
        System.out.println(ChronoUnit.NANOS.between(aniversario, now));
    }
}
