package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTests extends BaseTests {

    @Description("Checking data, clickability and functionality of buttons")
    @Test(description = "Checking data, clickability and functionality of buttons", groups = {"regression"})
    public void productsTest() {
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

    @Description("Check sorting in the products page")
    @Test(dataProvider = "Sorting", groups = {"regression"}, description = "Sort check")
    public void sortTest(String optionName, List<String> expectedItemList)  {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickDropdownButton();
        productsPage.selectSortingOrderOption(optionName);
        Assert.assertEquals(productsPage.getSortListItemName(), expectedItemList);
    }
}