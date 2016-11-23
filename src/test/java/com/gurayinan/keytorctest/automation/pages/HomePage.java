package com.gurayinan.keytorctest.automation.pages;

import com.gurayinan.keytorctest.automation.components.NavigationMenu;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private static final String N11_HOME_PAGE_URL = "http://www.n11.com";
    private final NavigationMenu navigationMenu;
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public HomePage open(){
        driver.get(N11_HOME_PAGE_URL);
        return this;
    }

    public NavigationMenu navigationMenu(){
        return navigationMenu;
    }
}
