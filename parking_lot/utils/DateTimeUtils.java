package utils;

import java.util.Date;

public class DateTimeUtils {

    public static int calcHours(Date start, Date end){
        long diff = end.getTime() - start.getTime();
        long diffInSec = diff/1000;
        return (int) Math.ceil((double) diffInSec/3600);
    }
}
