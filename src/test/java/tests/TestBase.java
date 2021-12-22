package tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;

public class TestBase {
    BasePage bp = new BasePage();

    @BeforeSuite
    public void setUp(){
        Assert.assertTrue(bp.goToHomePage(), "An error occurred while navigating to the homepage");
    }

    @AfterSuite
    public void tearDown(){
        bp.closeBrowser();
    }
}
