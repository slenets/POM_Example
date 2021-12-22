import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate from = LocalDate.now().plusDays(30);
        LocalDate to = LocalDate.now().plusDays(10);
        int month = from.getMonthValue();
        int day = from.getDayOfMonth();
        int year = from.getYear();

        String ss = LocalDate.now().format(dtf);
        System.out.println(month + " " + day + " " + year);
        System.out.println(ss);
        System.out.println("========================================");
        LocalDateTime ldt = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        DateTimeFormatter timeStamp = DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm");
        String s = timeStamp.format(ldt);
        System.out.println(s);
        File screenShot = new File(String.format("failed_tests/screen%st.txt", s));
        File file = new File("failed_tests/screencucaracha.png");
        try{
            Files.copy(file, screenShot);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
