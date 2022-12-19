package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Retry;

public class ItemTests extends BaseTests    {

    @Test(dataProvider = "ItemList", retryAnalyzer = Retry.class, description = "Data reconciliation and " +
            "clickability buttons", groups = {"slow"})
    public void itemTest(String testItemName, String testItemPrice, String testItemDescription)  {

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.openItem(testItemName);

        itemPage.getItemName(testItemName);
        Assert.assertEquals(itemPage.getItemName(testItemName), testItemName);
        itemPage.getItemDescription(testItemName);
        Assert.assertEquals(itemPage.getItemDescription(testItemName), testItemDescription);
        itemPage.getItemPrice(testItemName);
        Assert.assertEquals(itemPage.getItemPrice(testItemName), testItemPrice);
        itemPage.clickAddToCartButton(testItemName);
        Assert.assertTrue(itemPage.isShoppingBasketFull());
        itemPage.clickShoppingBasket(testItemName);
        Assert.assertTrue(basketPage.isCheckoutButtonPresent());
    }
}