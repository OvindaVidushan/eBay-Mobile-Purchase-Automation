package com.ebay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeeAllPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By firstItem =
            By.xpath("(//div[contains(@class,'x-prp-top-products_grid')]//a[@data-testid='ux-action'])[1]");

    public SeeAllPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void selectFirstItem() {
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(firstItem));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
        item.click();
    }
}