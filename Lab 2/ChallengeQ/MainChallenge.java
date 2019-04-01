import java.util.GregorianCalendar;
import java.util.Date;

public class MainChallenge {

    public static void main(String[] args) {
        Date date = new Date();
        GregorianCalendar gCal = new GregorianCalendar();

        System.out.println(" 1- Current Time (GregorianCalendar Method): " + gCal.getTime());
        System.out.println(" 2- Current Time (Date Method): " + date.toString());
        System.out.println(" 3- Current Time (in millisecond): " + date.getTime() + " ms");
        System.out.println(" 4- Current Year: " + gCal.get(GregorianCalendar.YEAR));
        System.out.println(" 5- Current Month: " + (gCal.get(GregorianCalendar.MONTH) + 1));
        System.out.println(" 6- Current Day: " + gCal.get(GregorianCalendar.DAY_OF_MONTH));
        System.out.println(" 7- Current Week: " + gCal.get(GregorianCalendar.DAY_OF_WEEK));
        System.out.println(" 8- Current Day of week in month: " + gCal.get(GregorianCalendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(" 9- Current Day of year: " + gCal.get(GregorianCalendar.DAY_OF_YEAR));
        System.out.println("10- Current Hour: " + gCal.get(GregorianCalendar.HOUR));
        System.out.println("11- Current Hour of day: " + gCal.get(GregorianCalendar.HOUR_OF_DAY));
        System.out.println("12- Current Minute: " + gCal.get(GregorianCalendar.MINUTE));
        System.out.println("13- Current Second: " + gCal.get(GregorianCalendar.SECOND));
        System.out.println("14- Current Millisecond: " + gCal.get(GregorianCalendar.MILLISECOND));
        System.out.println("15- Current Week of month: " + gCal.get(GregorianCalendar.WEEK_OF_MONTH));
        System.out.println("16- Current Week of Year: " + gCal.get(GregorianCalendar.WEEK_OF_YEAR));

        System.out.println("\n");
        long d = 1;
        for (int i = 0; i < 12; i++) {
            date.setTime(date.getTime() + d);
            System.out.println("The time after adding " + d + " millisecond(s) : " + date.toString());
            d *= 10;
        }

    }
}