package com.ebay.automation.tests;

import com.ebay.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test
    public void guestMobilePurchaseFlow() {

        HomePage home = new HomePage(driver, wait);
        SearchResultsPage results = new SearchResultsPage(driver, wait);
        SeeAllPage seeAll = new SeeAllPage(driver, wait);
        ProductDetailsPage product = new ProductDetailsPage(driver, wait);
        NewWindow newWindow = new NewWindow(driver);
        CartPage cart = new CartPage(driver, wait);

        home.open();
        Assert.assertTrue(driver.getCurrentUrl().contains("ebay.com"));

        // Hover Electronics → Smartphones and accessories
        home.goToSmartphonesAndAccessories();

        // Click "See All"
        results.clickSeeAll();

        // Select first item
        seeAll.selectFirstItem();

        // Print name + price
        String name = product.getItemName();
        String price = product.getItemPrice();
        System.out.println("Item Name  : " + name);
        System.out.println("Item Price : " + price);

        Assert.assertFalse(name.isBlank());
        Assert.assertFalse(price.isBlank());

        // Open "See all details" (opens new tab) → switch
        product.clickSeeAllDetails();
        newWindow.changeToNextWindow();

        // Add to cart and open cart
        cart.clickAddToCart();
        cart.openCart();

        String subtotal = cart.getSubtotal();
        System.out.println("Total      : " + subtotal);
        Assert.assertFalse(subtotal.isBlank());

        // Go to checkout (should lead to signin/guest options)
        cart.goToCheckout();

        // STOP here (assignment says stop where login is required)
        System.out.println("Reached checkout/login step - stopping as required.");
    }
}