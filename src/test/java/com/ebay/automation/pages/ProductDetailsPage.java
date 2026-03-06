package com.ebay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By title = By.xpath("//h1[contains(@class,'x-item-title__mainTitle')]//span");
    private final By price = By.xpath("//div[@data-testid='x-price-primary']//span");
    private final By seeAllDetails = By.xpath("//a[contains(., 'See all details')]");

    public ProductDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getItemName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText().trim();
    }

    public String getItemPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(price)).getText().trim();
    }

    public void clickSeeAllDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(seeAllDetails)).click();
    }
}