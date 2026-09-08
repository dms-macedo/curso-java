package academy.devdojo.maratonajava.javacore.Rdatas.test;

import org.w3c.dom.ls.LSOutput;

import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.*;

class ProximoDiaUtil implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int addDays;

        switch (dayOfWeek){
            case THURSDAY: addDays = 4; break;
            case FRIDAY: addDays = 3; break;
            case SATURDAY: addDays = 2; break;
            default: addDays = 1;
        }

        return temporal.plus(addDays, ChronoUnit.DAYS);
    }
}

public class TemporalAdjusterTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.of(2026, Month.SEPTEMBER, 10);
        LocalDate diaUtil = now.with(new ProximoDiaUtil());
        System.out.println("Dia de Hoje: " + now.getDayOfWeek() + " | Próximo Dia Útil: " + diaUtil.getDayOfWeek());
    }
}
