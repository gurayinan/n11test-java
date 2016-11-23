package com.gurayinan.keytorctest.automation.components;

import com.gurayinan.keytorctest.automation.pages.LoginPage;
import com.gurayinan.keytorctest.automation.pages.SearchResultsPage;
import com.gurayinan.keytorctest.automation.pages.FavoritesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationMenu {
    private static final By LOGIN_LINK = By.className("btnSignIn");
    private static final By SEARCH_INPUT = By.id("searchData");
    private static final By SEARCH_BUTTON = By.className("searchBtn");
    private static final By FAVORTIES_LINK = By.linkText("Favorilerim");
    private WebDriver driver;
    private WebDriverWait wait;

    public NavigationMenu(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 45);
    }

    public LoginPage navigateToLoginPage(){
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_LINK)).click();
        return new LoginPage(driver);
    }

    public SearchResultsPage searchFor(String search_context){
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_INPUT)).sendKeys(search_context);
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON)).click();
        return new SearchResultsPage(driver);
    }

    public FavoritesPage navigateToFavoritesPage(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
        Actions action = new Actions(driver);
        WebElement mainMenu = driver.findElement(By.className("myAccount"));
        action.moveToElement(mainMenu).perform();
        wait.until(ExpectedConditions.elementToBeClickable(FAVORTIES_LINK)).click();
        return new FavoritesPage(driver);
    }
}
