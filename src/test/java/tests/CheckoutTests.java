package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTests    {

    @Test(description = "Performance of input parameters and button", groups = {"slow"})
    public void checkoutTest()  {
        String testItemName = "Sauce Labs Bike Light";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.openItem(testItemName);
        itemPage.clickAddToCartButton(testItemName);
        itemPage.clickShoppingBasket(testItemName);
        basketPage.clickCheckoutButton();

        checkoutPage.clickCancelButton();
        Assert.assertEquals(basketPage.isCheckoutButtonPresent(), true);

        productsPage.back();

        checkoutPage.setFirstNameInput("kjdsvb");
        checkoutPage.setLastNameInput("djfndf");
        checkoutPage.setZipCodeInput("2356423");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isFinishButtonPresent());
    }
}