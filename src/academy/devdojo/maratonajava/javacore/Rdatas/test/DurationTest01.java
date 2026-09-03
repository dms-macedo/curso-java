package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DurationTest01 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldtAfter2Years = LocalDateTime.now().plusYears(2);

        LocalTime time = LocalTime.now();
        LocalTime timeMinus5Hours = LocalTime.now().minusHours(5);

        Duration d1 = Duration.between(ldt, ldtAfter2Years);
        Duration d2 = Duration.between(time, timeMinus5Hours);

        System.out.println(d1);
        System.out.println(d2);

        Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(3600));
        Duration d4 = Duration.ofDays(20);
        Duration d5 = Duration.ofMinutes(10);
        Duration d6 = Duration.of(3, ChronoUnit.HOURS);

        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
        System.out.println(d6);
    }

}
