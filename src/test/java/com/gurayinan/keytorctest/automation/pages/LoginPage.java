package com.gurayinan.keytorctest.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private static final By MAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By FORM_SUBMIT = By.id("loginButton");
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 45);
    }

    public HomePage loginUser(String mail, String password){
        wait.until(ExpectedConditions.elementToBeClickable(MAIL_INPUT)).sendKeys(mail);
        wait.until(ExpectedConditions.elementToBeClickable(PASSWORD_INPUT)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(FORM_SUBMIT)).click();
        return new HomePage(driver);
    }
}
