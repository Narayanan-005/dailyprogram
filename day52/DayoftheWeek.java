import java.time.LocalDate;
import java.util.Calendar;

public class DayoftheWeek {
    public static void main(String[] args) {
        int day = 15, month = 8, year = 1993;
        System.out.println(dayoftheWeek1(day, month, year));
        System.out.println(dayoftheWeek2(day, month, year));
        System.out.println(dayoftheWeek3(day, month, year));
    }

    private static String dayoftheWeek1(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int first = 6;
        int startYear = 1972;
        while (startYear < year) {
            if (isLeap(startYear)) {
                first += 2;
            } else {
                first += 1;
            }
            startYear++;
        }
        for (int i = 1; i < month; i++) {
            first += getDay(i, year);
        }
        first += day - 1;
        return days[first % 7];
    }

    private static int getDay(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2: {
                if (isLeap(year)) {
                    return 29;
                }
                return 28;
            }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
        return -1;
    }

    private static boolean isLeap(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    private static String dayoftheWeek2(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().toString();
    }

    private static String dayoftheWeek3(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}
