package tests;

import com.google.gson.internal.bind.util.ISO8601Utils;
import dto.Credentials;
import groovyjarjarasm.asm.ClassReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomeSearchPage;
import pages.RegistrationPage;

public class RegistrationTests extends TestBase{

    HomeSearchPage homeSearch = new HomeSearchPage();
    int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
    Credentials registration = Credentials.builder()
            .name("name")
            .lastName("lastName")
            .email(String.format("aa@aa%d.ru", i))
            .password(String.format("Password%d", i))
            .build();

    @BeforeMethod
    public void preconditions(){
        if(homeSearch.isLogoutPresent())
            homeSearch.userLogout();
    }

    @Test
    public void registrationValidData(){
        System.out.println(i);
        RegistrationPage registrationPage = homeSearch.registrationPage();
        registrationPage.fillSubmitRegistrationForm(registration);
        registrationPage.clickCheckBox();
        registrationPage.clickYallaButton();
        Assert.assertTrue(registrationPage.isRegisteredPresent());
        registrationPage.clickOk();
        Assert.assertTrue(homeSearch.isLogoutPresent());
    }
}
