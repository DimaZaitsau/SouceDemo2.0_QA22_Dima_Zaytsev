package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTests {

    @Test(description = "Checking data, clickability and functionality of buttons", groups = {"slow"})
    public void productsTest()  {

        String testItemName = "Sauce Labs Bike Light";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.getItemDescription(testItemName);
        productsPage.getItemPrice(testItemName);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.openItem(testItemName);
        Assert.assertTrue(itemPage.isBackToProductButtonPresent());
    }
}