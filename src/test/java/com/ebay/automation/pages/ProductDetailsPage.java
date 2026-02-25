package com.ebay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By title = By.cssSelector("h1#itemTitle");
    private final By price = By.cssSelector("div#prcIsum, div#prcIsum_bidPrice, span#prcIsum");
    private final By addToCart = By.id("isCartBtn_btn");

    public ProductDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getItemName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText().replace("Details about  \u00a0", "").trim();
    }

    public String getItemPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(price)).getText().trim();
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }
}