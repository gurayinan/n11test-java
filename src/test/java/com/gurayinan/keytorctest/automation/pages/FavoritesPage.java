package com.gurayinan.keytorctest.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FavoritesPage {
    private static final By DELETE_PRODUCT = By.className("removeSelectedProduct");
    private static final By EMPTY_WATCHLIST = By.className("emptyWatchList");
    private WebDriver driver;
    private WebDriverWait wait;

    public FavoritesPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 45);
    }

    public void checkIfListEmpty(){
        wait.until(ExpectedConditions.presenceOfElementLocated(EMPTY_WATCHLIST));
    }

    public FavoritesPage deleteProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(DELETE_PRODUCT)).click();
        return new FavoritesPage(driver);
    }
}
