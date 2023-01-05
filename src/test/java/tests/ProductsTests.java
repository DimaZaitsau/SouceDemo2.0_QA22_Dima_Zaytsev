package tests;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTests extends BaseTests {

    @Step("Clickability buttons on the Products Page")
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

    @Step("The correct function sorting on the Products Page {optionName}")
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