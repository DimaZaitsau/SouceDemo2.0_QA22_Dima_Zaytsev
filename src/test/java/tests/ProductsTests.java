package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;

public class ProductsTests extends BaseTests {
    @Test(description = "Checking data, clickability and functionality of buttons", groups = {"slow"})
    public void productsTest() {

        String testItemName = "Sauce Labs Bike Light";

        String[] expectedAToZSortingItemList = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};
        String[] expectedZToASortingItemList = {"Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie",
                "Sauce Labs Fleece Jacket", "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light", "Sauce Labs Backpack"};
        String[] expectedLowToHighSortingItemList = {"Sauce Labs Onesie", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Backpack", "Sauce Labs Fleece Jacket"};
        String[] expectedHighToLowSortingItemList = {"Sauce Labs Fleece Jacket", "Sauce Labs Backpack",
                "Sauce Labs Bolt T-Shirt", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Bike Light", "Sauce Labs Onesie"};

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.getItemDescription(testItemName);
        productsPage.getItemPrice(testItemName);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.openItem(testItemName);
        Assert.assertTrue(itemPage.isBackToProductButtonPresent());
        productsPage.back();

        productsPage.clickDropdownButton();
        productsPage.clickSelectAToZ();
        Assert.assertEquals(productsPage.getSortListItemName(), Arrays.asList(expectedAToZSortingItemList));
        productsPage.clickDropdownButton();
        productsPage.clickSelectZToA();
        Assert.assertEquals(productsPage.getSortListItemName(), Arrays.asList(expectedZToASortingItemList));
        productsPage.clickDropdownButton();
        productsPage.clickSelectLowToHigh();
        Assert.assertEquals(productsPage.getSortListItemName(), Arrays.asList(expectedLowToHighSortingItemList));
        productsPage.clickDropdownButton();
        productsPage.clickSelectHighToLow();
        Assert.assertEquals(productsPage.getSortListItemName(), Arrays.asList(expectedHighToLowSortingItemList));
    }
}