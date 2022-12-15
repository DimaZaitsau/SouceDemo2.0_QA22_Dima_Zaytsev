package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemTests extends BaseTests    {

    @Test
    public void itemTest()  {
        String testItemName = "Sauce Labs Bike Light";
        String testItemDescription = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
        String testItemPrice = "$9.99";

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