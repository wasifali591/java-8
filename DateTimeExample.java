import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class DateTimeExample {
    public static void main(String[] args) {
        //current date
        LocalDate today = LocalDate.now();
        System.out.println("Current Date: " + today);

        //Creating LocalDate by providing input arguments
        LocalDate firstDay2024 = LocalDate.of(2024, Month.JANUARY, 1);
        System.out.println("Specific Date: " + firstDay2024);

        //Current date in Asia/Kolkata 
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date IST: " + todayKolkata);

        //getting date from base date i.e. 01/01/1970
        LocalDate dateFromBaseDate = LocalDate.ofEpochDay(365);
        System.out.println("365 day from the base date: " + dateFromBaseDate);

        LocalDate hundredDay2024 = LocalDate.ofYearDay(2024, 100);
        System.out.println("100th day of 2024: " + hundredDay2024);

    }
}
