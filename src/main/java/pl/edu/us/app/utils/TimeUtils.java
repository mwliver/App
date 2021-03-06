package pl.edu.us.app.utils;

import java.util.concurrent.TimeUnit;

/**
 * Copyright (C) Coderion sp. z o.o
 */
public class TimeUtils {

    public static String millisToShortDHMS(long duration) {
        String res = "";
        long days  = TimeUnit.MILLISECONDS.toDays(duration);
        long hours = TimeUnit.MILLISECONDS.toHours(duration)
                - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
        if (days == 0) {
            res = String.format("%02dh:%02dm:%02ds", hours, minutes, seconds);
        }
        else {
            res = String.format("%dd%02dh:%02dm:%02ds", days, hours, minutes, seconds);
        }
        return res;
    }
}
