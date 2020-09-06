package com.example.java8to11.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
        Instant instant = Instant.now();// 기준시 UTC, GMT
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime birthDay = LocalDateTime.of(1988, Month.JANUARY, 29, 0, 0, 0);
        System.out.println(birthDay);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthDay = LocalDate.of(2020, Month.JANUARY, 29);

        Period period = Period.between(today, thisYearBirthDay);
        System.out.println(period.getMonths() + ":" + period.getDays());

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(dateTime.format(dateTimeFormatter));



    }
}
