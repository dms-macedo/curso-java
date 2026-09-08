package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map;

public class ZoneTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        System.out.println(now);
        System.out.println(shortIds);

        ZoneId zoneDefault = ZoneId.systemDefault();
        System.out.println(zoneDefault);
        ZoneId zoneIdSaoPaulo = ZoneId.of("America/Sao_Paulo");
        System.out.println(zoneIdSaoPaulo);

    }
}
