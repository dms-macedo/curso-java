package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalTime;

public class LocalTimeTest01 {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(23 , 44 , 33);
        LocalTime now = LocalTime.now();

        System.out.println(time);
        System.out.println(now);
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MAX);
    }
}
