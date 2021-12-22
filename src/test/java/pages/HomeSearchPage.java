package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


//setTimeout(()=>console.log(document.querySelector('.subjects-auto-complete__menu').innerHTML),10000);

public class HomeSearchPage extends BasePage {
    By loginLink = By.xpath("//a[text()=' Log in ']");
    By signUpLink = By.cssSelector("a.navigation-link[href = '/registration?url=%2Fsearch']");
    By searchPage = By.cssSelector(".navigation-link[href='/search']");
    By letCarWorkPage = By.cssSelector(".navigation-link[href='/let-car-work']");
    By cityInput = By.id("city");
    By datesInput = By.id("dates");
    By pacItemCity = By.cssSelector(".pac-item");


    By logoutLink = By.xpath("//a[text()=' Logout ']");
    By deleteLink = By.xpath("//a[text()='Delete account']");

    By tryAgainError = By.xpath("//button[text()='Try again']");


    public SearchResultPage searchCarForm(String city, LocalDate from, LocalDate to) throws InterruptedException {
        //mm/dd/yyyy
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate now = LocalDate.now();
        int dayFrom = from.getDayOfMonth();
        int monthFrom = from.getMonthValue();
        int yearFrom = from.getYear();

        int dayTo = to.getDayOfMonth();
        int monthTo = to.getMonthValue();
        int yearTo = to.getYear();

        typeSend(getElement(cityInput), city);
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(pacItemCity)).click().perform();
        click(datesInput);

        if (monthFrom != now.getMonthValue()) {
            driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
            driver.findElement(By.xpath(String.format("//div[text()=' %d ']", yearFrom))).click();
            List<WebElement> elementList = driver.findElements(By.className("mat-calendar-body-cell-content"));
            elementList.get(monthFrom-1).click();
        }
        driver.findElement(By.xpath(String.format("//div[text()=' %d ']", dayFrom))).click();

            if (monthTo != monthFrom) {
                driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
                driver.findElement(By.xpath(String.format("//div[text()=' %d ']", yearTo))).click();
                Thread.sleep(2000);
                List<WebElement> elementList = driver.findElements(By.className("mat-calendar-body-cell-content"));
                System.out.println(elementList.size());
                elementList.get(monthTo-1).click();
            }
            driver.findElement(By.xpath(String.format("//div[text()=' %d ']", dayTo))).click();

        clickYallaButton();

//        if(isElementPresent(getElement(tryAgainError))){
//            getElement(tryAgainError).click();
//        }

        return new SearchResultPage();
    }


    public LoginPage loginPage() {
        click(loginLink);
        return new LoginPage();
    }

    public RegistrationPage registrationPage() {
        click(signUpLink);
        return new RegistrationPage();
    }

    public void userLogout() {
        click(logoutLink);
    }

    public boolean isLogoutPresent() {
        //new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(logoutLink));
        return driver.findElement(logoutLink).isDisplayed();
    }

    public boolean isDeletePresent() {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(getElement(deleteLink)));
            return driver.findElement(deleteLink).isDisplayed();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return false;
    }


}
