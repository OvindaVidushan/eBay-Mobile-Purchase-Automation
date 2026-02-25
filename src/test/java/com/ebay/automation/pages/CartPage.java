package com.ebay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cartItemTitle = By.cssSelector("div[data-test-id='cart-item'] a[data-test-id='cart-item-link'], a[data-test-id='cart-item-title']");
    private final By cartItemPrice = By.cssSelector("[data-test-id='cart-item-price'], span[itemprop='price']");
    private final By proceedToCheckout = By.cssSelector("button[data-test-id='cta-top'], a[data-test-id='cta-top']");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getCartItemName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemTitle)).getText().trim();
    }

    public String getCartItemPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemPrice)).getText().trim();
    }

    public void clickProceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout)).click();
    }
}