package com.ebay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    private final By electronicsMenu = By.xpath("//a[normalize-space()='Electronics']");
    private final By smartphonesAccessories = By.xpath("//a[normalize-space()='Smartphones and accessories']");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.actions = new Actions(driver);
    }

    public void open() {
        driver.get("https://www.ebay.com/");
        wait.until(d -> d.getCurrentUrl().contains("ebay.com"));
    }

    public void goToSmartphonesAndAccessories() {
        WebElement elec = wait.until(ExpectedConditions.visibilityOfElementLocated(electronicsMenu));
        actions.moveToElement(elec).perform();
        wait.until(ExpectedConditions.elementToBeClickable(smartphonesAccessories)).click();
    }
}