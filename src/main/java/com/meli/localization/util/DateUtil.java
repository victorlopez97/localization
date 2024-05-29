package com.meli.localization.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {
    public static String extractTimeByZone(String[] timeZones) {
        List<String> formattedTimes = new ArrayList<>();
        for (String timeZone : timeZones) {
            ZonedDateTime nowTime = ZonedDateTime.now(ZoneId.of("America/Bogota"));
            ZonedDateTime convertedTime = nowTime.withZoneSameInstant(ZoneId.of(timeZone));
            String formattedTime = formatTime(convertedTime.toLocalTime()) + " " + formatTimeZone(timeZone);
            formattedTimes.add(formattedTime);
        }
        return String.join(" o ", formattedTimes);
    }

    public static String formatTime(LocalTime time) {
        return time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public static String formatTimeZone(String timeZone) {
        return "(" + timeZone + ")";
    }
    public static String convertNowDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return  sdf.format(date);
    }

    public static String convertDateFormat(String dateString) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, inputFormatter);
        return dateTime.format(outputFormatter);
    }
}
