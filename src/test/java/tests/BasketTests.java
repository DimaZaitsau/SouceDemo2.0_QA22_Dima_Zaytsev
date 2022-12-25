package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasketTests extends BaseTests  {

    @Test(description = "Performance of the shopping cart", groups = {"regression"})
    public void basketTest()    {

        String testItemName = "Sauce Labs Bike Light";
        String testItemDescription = "A red light isn't the desired state in testing but it sure helps when riding " +
                "your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
        String testItemPrice = "$9.99";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        productsPage.openItem(testItemName);
        itemPage.clickAddToCartButton(testItemName);
        itemPage.clickShoppingBasket(testItemName);
        basketPage.getItemName(testItemName);
        Assert.assertEquals(basketPage.getItemName(testItemName), testItemName);
        basketPage.getItemDescription(testItemName);
        Assert.assertEquals(basketPage.getItemDescription(testItemName), testItemDescription);
        basketPage.getItemPrice(testItemName);
        Assert.assertEquals(basketPage.getItemPrice(testItemName), testItemPrice);
        basketPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isFirstNameInputPresent());
        productsPage.back();
        basketPage.clickRemoveButton();
        Assert.assertEquals(basketPage.numberOfItemsInBasket(), false);
        basketPage.clickContinueShoppingButton();
        Assert.assertTrue(productsPage.isDropdownPresent());
    }
}