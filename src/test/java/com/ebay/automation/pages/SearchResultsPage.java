package com.ebay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Results (can vary; we’ll fix if your run shows different)
    private final By resultItems = By.cssSelector("ul.srp-results li.s-item");
    private final By resultTitleLink = By.cssSelector("a.s-item__link");

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickFirstResult() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(resultItems));
        List<WebElement> items = driver.findElements(resultItems);

        for (WebElement item : items) {
            List<WebElement> links = item.findElements(resultTitleLink);
            if (!links.isEmpty()) {
                links.get(0).click();
                return;
            }
        }
        throw new RuntimeException("No clickable result found on search results page.");
    }
}