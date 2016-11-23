package com.gurayinan.keytorctest.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage {
    private static final By SEARCH_RESULT_TITLE = By.className("resultText");
    private static final By SECOND_RESULT_PAGE = By.linkText("2");
    private static final By THIRD_PRODUCT_FAVORITE = By.cssSelector(".followBtn:nth-child(3)");
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 45);
    }

    public String getSearchResultText(){
        return driver.findElement(SEARCH_RESULT_TITLE).getText();
    }

    public SearchResultsPage navigateToSecondPage(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
        ((JavascriptExecutor) driver).executeScript("$.fancybox.close()");
        wait.until(ExpectedConditions.elementToBeClickable(SECOND_RESULT_PAGE)).click();
        return new SearchResultsPage(driver);
    }

    public void addProductToFavorites(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 500);");
        wait.until(ExpectedConditions.presenceOfElementLocated(THIRD_PRODUCT_FAVORITE)).click();
    }


}
