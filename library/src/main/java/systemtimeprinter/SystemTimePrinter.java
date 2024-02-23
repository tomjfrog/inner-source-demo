package src.main.java.systemtimeprinter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemTimePrinter {
    public static void printSystemTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println("Current system time: " + formattedDateTime);
    }
}
