package pages;

import dto.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.swing.*;

public class RegistrationPage extends BasePage {
    By nameField = By.id("name");
    By lastNameField = By.id("lastName");
    By emailField = By.id("email");
    By passwordField = By.id("password");
    By regCheckBox = By.id("terms-of-use");
    By registeredPopup = By.cssSelector("div.dialog-container h1.title");
    By okBtn = By.cssSelector("button[type='button']");
    By checkBoxReg = By.cssSelector(".checkbox-label.terms-label");

    public void fillSubmitRegistrationForm(Credentials credentials) {
        typeSend(getElement(nameField), credentials.getName());
        typeSend(getElement(lastNameField), credentials.getLastName());
        typeSend(getElement(emailField), credentials.getEmail());
        typeSend(getElement(passwordField), credentials.getPassword());
    }

    public boolean isCheckBoxEnabled() {
        return getElement(regCheckBox).isSelected();
    }

    public void clickCheckBox() {
        WebElement element = getElement(checkBoxReg);
        int x = element.getLocation().getX() + element.getRect().getWidth() * 10 / 100;
        int y = element.getLocation().getY() + element.getRect().getHeight() / 2;
        System.out.println(x + "    " + y);

        Actions actions = new Actions(driver);
        actions.moveByOffset(x, y).click().perform();

        //getElement(regCheckBox).click();
    }

    public HomeSearchPage clickOk() {
        getElement(okBtn).click();
        return new HomeSearchPage();
    }

    public boolean isRegisteredPresent() {
        return isElementPresent(registeredPopup) && isElementPresent(okBtn);
    }


}
