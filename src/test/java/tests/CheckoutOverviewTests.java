package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTests extends BaseTests    {

    @Test
    public void checkoutOverviewTest()   {
        String testItemName = "Sauce Labs Backpack";
        String testItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        String testItemPrice = "$29.99";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.openItem(testItemName);
        itemPage.clickAddToCartButton(testItemName);
        itemPage.clickShoppingBasket(testItemName);
        basketPage.clickCheckoutButton(testItemName);
        checkoutPage.setFirstNameInput("kjdsvb");
        checkoutPage.setLastNameInput("djfndf");
        checkoutPage.setZipCodeInput("2356423");
        checkoutPage.clickContinueButton();

        checkoutOverviewPage.getItemName(testItemName);
        Assert.assertEquals(checkoutOverviewPage.getItemName(testItemName), testItemName);
        checkoutOverviewPage.getItemDescription(testItemName);
        Assert.assertEquals(checkoutOverviewPage.getItemDescription(testItemName), testItemDescription);
        checkoutOverviewPage.getItemPrice(testItemName);
        Assert.assertEquals(checkoutOverviewPage.getItemPrice(testItemName), testItemPrice);
        checkoutOverviewPage.clickCancelButton();
        Assert.assertTrue(productsPage.isDropdownPresent());
        driver.getWindowHandle();
        driver.navigate().back();
        checkoutOverviewPage.clickShoppingBasketButton();
        Assert.assertTrue(basketPage.isCheckoutButtonPresent());
        driver.navigate().back();
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.isFinishTextPresent());
    }
}