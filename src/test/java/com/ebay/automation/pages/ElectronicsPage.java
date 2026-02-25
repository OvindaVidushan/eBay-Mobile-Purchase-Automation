package com.ebay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElectronicsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // These locators can vary slightly on eBay; we’ll adjust if needed
    private final By cellPhonesAndSmartphones = By.linkText("Cell Phones & Smartphones");
    private final By seeAll = By.linkText("See All");

    public ElectronicsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openCellPhonesAndSmartphones() {
        wait.until(ExpectedConditions.elementToBeClickable(cellPhonesAndSmartphones)).click();
    }

    public void clickSeeAll() {
        wait.until(ExpectedConditions.elementToBeClickable(seeAll)).click();
    }
}