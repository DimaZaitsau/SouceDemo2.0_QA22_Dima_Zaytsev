package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTests    {

    @Description("Check input parameters and button in the checkout page")
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

    @Description("Check negative input parameters and buttons in the checkout page")
    @Test(dataProvider = "NegativeCheckout", description = "Performance of input parameters and button", groups = {"regression"})
    public void negativeCheckoutTest(String testFirstName, String testLastName, String testZipCode) {
        String testItemName = "Sauce Labs Bike Light";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.openItem(testItemName);
        itemPage.clickAddToCartButton(testItemName);
        itemPage.clickShoppingBasket(testItemName);
        basketPage.clickCheckoutButton();
        checkoutPage.clickCancelButton();
        productsPage.back();
        checkoutPage.setFirstNameInput(testFirstName);
        checkoutPage.setLastNameInput(testLastName);
        checkoutPage.setZipCodeInput(testZipCode);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isFirstNameInputPresent());
        productsPage.back();
        basketPage.clickRemoveButton();
        productsPage.clickBurgerButton();
        productsPage.clickLogoutButton();
    }

    @Description("Check input parameters and button in the checkout page without item")
    @Test(description = "Continue button shouldn't click without item", groups = {"regression"})
    public void negativeCheckoutTestWithoutItem()   {
        String testItemName = "Sauce Labs Bike Light";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.openItem(testItemName);
        itemPage.clickShoppingBasket(testItemName);
        basketPage.clickCheckoutButton();
        checkoutPage.setFirstNameInput("kjdsvb");
        checkoutPage.setLastNameInput("djfndf");
        checkoutPage.setZipCodeInput("2356423");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isFirstNameInputPresent());
    }
}