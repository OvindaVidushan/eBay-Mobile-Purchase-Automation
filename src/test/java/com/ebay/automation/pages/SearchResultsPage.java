package com.ebay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By seeAll = By.xpath("//a[span[contains(text(), 'See All')]]");

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickSeeAll() {
        wait.until(ExpectedConditions.elementToBeClickable(seeAll)).click();
    }
}