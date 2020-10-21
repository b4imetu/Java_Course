import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class p4ShowCurrentTime_JSR310 {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("Current time is " + now + " GMT+08:00");
        // 输出LocalTime
        LocalDateTime LocalDateTimeNow = LocalDateTime.now();
        System.out.println("LocalDateTime is " + LocalDateTimeNow);
        // 输出LocalDateTime
        Long newSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("The elapsed time since Jan 1, 1970 is " + newSecond + " milliseconds");
        // 输出毫秒数
    }
}