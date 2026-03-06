package com.ebay.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By addToCart = By.xpath("//a[@id='atcBtn_btn_1']");
    private final By cartIcon = By.cssSelector("a[href='https://cart.ebay.com']");
    private final By subtotal = By.cssSelector("div[data-test-id='SUBTOTAL'] span.text-display-span");
    private final By goToCheckout = By.xpath("//a[contains(@href, '/checkout')] | //button[contains(text(), 'Go to checkout')]");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public String getSubtotal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subtotal)).getText().trim();
    }

    public void goToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(goToCheckout)).click();
    }
}