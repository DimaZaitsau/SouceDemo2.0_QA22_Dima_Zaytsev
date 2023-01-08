package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Retry;

public class ItemTests extends BaseTests    {

    @Description("Data consistency check in the item page")
    @Test(dataProvider = "ItemList", retryAnalyzer = Retry.class, description = "Data reconciliation and " +
            "clickability buttons", groups = {"regression"})
    public void itemTest(String testItemName, String testItemPrice, String testItemDescription)  {

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.openItem(testItemName);
        Assert.assertEquals(itemPage.getItemName(testItemName), testItemName);
        Assert.assertEquals(itemPage.getItemDescription(testItemName), testItemDescription);
        Assert.assertEquals(itemPage.getItemPrice(testItemName), testItemPrice);
        itemPage.clickAddToCartButton(testItemName);
        Assert.assertTrue(itemPage.isShoppingBasketFull());
        itemPage.clickShoppingBasket(testItemName);
        Assert.assertTrue(basketPage.isCheckoutButtonPresent());
    }
}