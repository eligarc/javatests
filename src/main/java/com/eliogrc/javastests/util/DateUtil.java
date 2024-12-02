package com.eliogrc.javastests.util;

import java.time.Year;

public class DateUtil {
    public static boolean isLeapYear(int year) {
        // return Year.of(year).isLeap();
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
