package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Insurance {

    enum FormatStyle {SHORT, LONG, FULL}

    private ZonedDateTime start; // дата-время начала действия страховки
    private Duration duration; // продолжительность действия

    Insurance(ZonedDateTime start) {
        this.start = start;
    }

    // установить дату-время начала действия страховки
    public void setStart(ZonedDateTime start) {
        this.start = start;
    }

    Insurance(String strStart, FormatStyle style) {
        start = styledStringToZDT(strStart, style);
    }

    // найти дату-время по строке с заданным форматом
    private ZonedDateTime styledStringToZDT(String strStart, FormatStyle style) {
        DateTimeFormatter formatter;
        switch (style) {
            case SHORT:
                formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                break;
            case LONG:
                formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                break;
            case FULL:
                formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                break;
            default:
                formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        }
        LocalDate date = LocalDate.parse(strStart, formatter);
        return date.atStartOfDay(ZoneId.systemDefault());
    }

    // установить продолжительность действия страховки
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    // установить продолжительность действия страховки, задав дату-время окончания
    public void setDuration(ZonedDateTime stop) {
        duration = Duration.between(start, stop);
    }

    public void setDuration(String durationStr, FormatStyle style) {
        switch (style) {
            case SHORT:
                duration = Duration.ofMillis(Integer.parseInt(durationStr));
                break;
            case LONG:
                LocalDateTime date0 = LocalDateTime.parse("0000-01-01T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                LocalDateTime date1 = LocalDateTime.parse(durationStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME).plusMonths(1).plusDays(1);
                duration = Duration.between(date0, date1);
                break;
            case FULL:
                duration = Duration.parse(durationStr);
                break;
            default:
                duration = Duration.parse(durationStr);
        }
    }

    // установить продолжительность действия страховки, задав целыми числами количество месяцев, дней и часов
    public void setDuration(int mons, int days, int hrs) {
        ZonedDateTime ldt = start == null ? ZonedDateTime.now() : start;
        ldt = ldt.plusMonths(mons).plusDays(days).plusHours(hrs);
        duration = Duration.between(start, ldt);
    }

    // проверить валидна ли страховка на указанную дату-время
    public boolean checkValid(ZonedDateTime dateTime) {
        if (duration == null) return dateTime.isAfter(start);
        ZonedDateTime end = start.plusHours(duration.toHours());
        return dateTime.isAfter(start) && dateTime.isBefore(end);
    }

    // вернуть строку формата "Insurance "+start+" "+duration
    @Override
    public String toString() {
        return "Insurance issued on " + start + " is " + (checkValid(ZonedDateTime.now()) ? "" : "not ") + "valid";
    }

    public static void main(String[] args) {

    }
}