package listener;

import ch.qos.logback.core.util.FileUtil;
import com.google.common.io.Files;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.BasePage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ListenerNG extends BasePage implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LocalDateTime ldt = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        DateTimeFormatter timeStamp = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH-mm-ss");
        String s = timeStamp.format(ldt);
        System.out.println(s);
        File screenShot = new File(String.format("failed_tests/screen_%s.png", s));
        TakesScreenshot screenshot2 = (TakesScreenshot) driver;
        File file = screenshot2.getScreenshotAs(OutputType.FILE);
        try{
            Files.copy(file, screenShot);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
