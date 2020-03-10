package ru.progwards.MichAll;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class TimeCl {
    Instant createInstant() {
        LocalDateTime ldt1 = LocalDateTime.of(2020,1,1,15,0,0,1);
        ZonedDateTime ldt2 = ldt1.atZone(ZoneId.of("+03:00:00"));
        return ldt2.toInstant();
    }

    static ZonedDateTime parseZDT(String str) {
        Locale l = Locale.forLanguageTag("EN");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD.MM.yyyy HH:mm:ss.SSS Z zzzz", l);
        return ZonedDateTime.parse(str, dtf.withZone(ZoneId.of("Europe/Moscow")));
    }
//        "dd.MM.yyyy HH:mm:ss.S"
//        "'От''езд' - EEEE dd MMMM 'в' ha"
//        "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'"

    public static void main(String[] args) {
        TimeCl timeCl = new TimeCl();
        System.out.println(timeCl.createInstant());
        System.out.println(timeCl.parseZDT("01.01.2020 16:27:14.444 +0300 Moscow Standard Time"));
    }
}
