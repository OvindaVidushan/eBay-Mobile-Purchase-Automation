package com.ebay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElectronicsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cellPhonesAndSmartphones = By.linkText("Cell Phones & Smartphones");

    public ElectronicsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openCellPhonesAndSmartphones() {
        wait.until(ExpectedConditions.elementToBeClickable(cellPhonesAndSmartphones)).click();
    }
}