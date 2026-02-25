package com.ebay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By electronicsMenu = By.linkText("Electronics");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://www.ebay.com/");
        wait.until(d -> d.getCurrentUrl().contains("ebay.com"));
    }

    public void clickElectronics() {
        wait.until(ExpectedConditions.elementToBeClickable(electronicsMenu)).click();
    }
}
