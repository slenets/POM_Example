package tests;
import dto.Credentials;
import listener.ListenerNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomeSearchPage;
import pages.LoginPage;

@Listeners(ListenerNG.class)
public class LoginTests extends TestBase{
    HomeSearchPage homeSearch = new HomeSearchPage();
    Credentials login = Credentials.builder().email("slavka.lenetz@gmail.com").password("Ilcarro123").build();

    @Test
    public void loginValidData(){
        homeSearch.loginPage();
        LoginPage p = homeSearch.loginPage();
        p.fillSubmitLoginForm(login);
        Assert.assertTrue(homeSearch.isDeletePresent());
    }
}
