package java8;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @Author Mayank Gupta
 * @Date 10/15/17
 */
public class DateTime {

    public static void main(String args[]) {

        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        final ZonedDateTime zonedDateTime1 = ZonedDateTime.now(clock);
        System.out.println(zonedDateTime1);
        final ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("America"));
        System.out.println(zonedDateTime2);
    }
}
