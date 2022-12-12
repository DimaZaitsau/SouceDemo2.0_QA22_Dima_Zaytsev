package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTests    {

    @Test
    public void checkoutTest()  {
        String testItemName = "Sauce Labs Backpack";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.openItem(testItemName);
        itemPage.clickAddToCartButton(testItemName);
        itemPage.clickShoppingBasket(testItemName);
        basketPage.clickCheckoutButton(testItemName);

        checkoutPage.clickCancelButton();
        Assert.assertEquals(basketPage.isCheckoutButtonPresent(), true);
        driver.getWindowHandle();
        driver.navigate().back();

        checkoutPage.setFirstNameInput("kjdsvb");
        checkoutPage.setLastNameInput("djfndf");
        checkoutPage.setZipCodeInput("2356423");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isFinishButtonPresent());
    }
}