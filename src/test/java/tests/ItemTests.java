package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemTests extends BaseTests    {

    @Test
    public void itemTest()  {
        String testItemName = "Sauce Labs Backpack";
        String testItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        String testItemPrice = "$29.99";

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