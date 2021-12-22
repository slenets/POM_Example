package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomeSearchPage;
import pages.SearchResultPage;

import java.time.LocalDate;

public class SearchCarTest extends TestBase {
    HomeSearchPage searchPage = new HomeSearchPage();
    String city = "Tel aviv";
    LocalDate from = LocalDate.now().plusDays(2);
    LocalDate to = LocalDate.now().plusDays(30);


    @Test
    public void searchCarTest() throws InterruptedException {
        SearchResultPage resultPage = searchPage.searchCarForm(city, from, to);
        Assert.assertTrue(resultPage.isCarImagePresent());

    }
}
