package pages;
import dto.Credentials;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    By emailField = By.id("email");
    By passwordField = By.id("password");
    By loggedInPopup = By.cssSelector("div.dialog-container h1.tile");
    By okBtn = By.cssSelector("button[type='button']");

    public HomeSearchPage fillSubmitLoginForm(Credentials credentials){
        typeSend(driver.findElement(emailField), credentials.getEmail());
        typeSend(driver.findElement(passwordField), credentials.getPassword());
        clickYallaButton();
        click(okBtn);
        return new HomeSearchPage();
    }

    public void clickOk(){
        click(okBtn);
    }
}
