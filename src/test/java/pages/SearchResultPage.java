package pages;

import org.openqa.selenium.By;

public class SearchResultPage extends BasePage{

    By carImage = By.className("car-container");
    By tryAgainError = By.xpath("//button[text()='Try again']");
    By closeError = By.xpath("//button[text()='Close']");

    public boolean isCarImagePresent(){
        if(isConnectionError()){
            click(tryAgainError);
        }
        return isElementPresent(carImage);
    }

    public boolean isConnectionError(){
        return isElementPresent(tryAgainError);
    }
}
