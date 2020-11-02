package ru.sber.javareboot;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTest {
    public static void main(String[] args) {
        String date = LocalDate.of(1991, 6,13)
                .format(DateTimeFormatter.ofPattern("dd MMMM yyyy")).toUpperCase();

        System.out.println(date);
    }
}
