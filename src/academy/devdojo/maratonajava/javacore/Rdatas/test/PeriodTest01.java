package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.Period;

public class PeriodTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate nowAfter2Years = LocalDate.now().plusYears(2);

        Period period = Period.between(now, nowAfter2Years);
        System.out.println(period);

        Period p2 = Period.ofDays(20);
        Period p3 = Period.ofWeeks(58);
        Period p4 = Period.ofMonths(2);
        Period p5 = Period.ofYears(9);

        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
    }
}
