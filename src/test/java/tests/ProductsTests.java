package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ProductsTests extends BaseTests {

    @Test(description = "Checking data, clickability and functionality of buttons", groups = {"slow"})
    public void productsTest() throws InterruptedException {

        String testItemName = "Sauce Labs Bike Light";

        String[] expectedAToZSortingItemList = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};
        String[] expectedZToASortingItemList = {"Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie",
                "Sauce Labs Fleece Jacket", "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light", "Sauce Labs Backpack"};
        String[] expectedLowToHighSortingItemList = {"Sauce Labs Onesie", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Backpack", "Sauce Labs Fleece Jacket"};
        String[] expectedHighToLowSortingItemList = {"Sauce Labs Fleece Jacket", "Sauce Labs Backpack",
                "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light", "Sauce Labs Onesie"};

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.getItemDescription(testItemName);
        productsPage.getItemPrice(testItemName);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.openItem(testItemName);
        Assert.assertTrue(itemPage.isBackToProductButtonPresent());
        productsPage.back();

        productsPage.clickSelectAToZ();
        Assert.assertEquals(productsPage.sortListItemNameAToZ(), Arrays.asList(expectedAToZSortingItemList));
        productsPage.clickSelectZToA();
        Assert.assertEquals(productsPage.sortListItemNameZToA(), Arrays.asList(expectedZToASortingItemList));
// Почему-то productsPage.sortListItemNameZToA() получается как expectedAToZSortingItemList.

        productsPage.clickSelectLowToHigh();
        Assert.assertEquals(productsPage.sortListItemNameLowToHigh(), Arrays.asList(expectedLowToHighSortingItemList));
        productsPage.clickSelectHighToLow();
        Assert.assertEquals(productsPage.sortListItemNameHighToLow(), Arrays.asList(expectedHighToLowSortingItemList));
    }
}