package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasketTests extends BaseTests  {

    @Test
    public void basketTest()    {
        String testItemName = "Sauce Labs Backpack";
        String testItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        String testItemPrice = "$29.99";

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
        basketPage.clickCheckoutButton(testItemName);
        Assert.assertTrue(checkoutPage.firstNameInput());
        driver.getWindowHandle();
        driver.navigate().back();

        basketPage.clickRemoveButton(testItemName);
        try {
            Assert.assertTrue(basketPage.numberOfItemsInBasket());
        } catch (AssertionError ex) {
            System.out.println("0 items in basket");
        }

        basketPage.clickContinueShoppingButton(testItemName);
        Assert.assertTrue(productsPage.isDropdownPresent());
    }
}