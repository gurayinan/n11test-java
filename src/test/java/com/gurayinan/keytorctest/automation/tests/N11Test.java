package com.gurayinan.keytorctest.automation.tests;

import com.gurayinan.keytorctest.automation.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class N11Test{

    private WebDriver driver;
    private HomePage homePage;
    private static final String loginUser = "gurayinan@yandex.com";
    private static final String loginPassword = "testapp123";
    private static final String searchContext = "samsung";

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriverMac64");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void openHomePage() {
        homePage = new HomePage(driver).open();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAddingItemToWishList() {
        LoginPage loginPage = homePage.navigationMenu().navigateToLoginPage();
        HomePage homePage = loginPage.loginUser(loginUser, loginPassword);
        SearchResultsPage searchResultsPage = homePage.navigationMenu().searchFor(searchContext);
        SearchResultsPage searchResultsPageTwo = searchResultsPage.navigateToSecondPage();
        searchResultsPageTwo.addProductToFavorites();
        FavoritesPage favoritesPage = homePage.navigationMenu().navigateToFavoritesPage();
        FavoritesPage favEmpty = favoritesPage.deleteProduct();
        favEmpty.checkIfListEmpty();
    }
}
