package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTests    {

    @Description("Check input parameters and button in the checkout page")
    @Test(description = "Performance of input parameters and button", groups = {"slow"})
    public void checkoutTest()  {
        String testItemName = "Sauce Labs Bike Light";

        boolean isPageOpened = loginPage
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton().isPageOpen();
        Assert.assertTrue(isPageOpened, "ProductsPage is not opened");
        isPageOpened = productsPage.openItem(testItemName).isPageOpen();
        Assert.assertTrue(isPageOpened, "ItemPage is not opened");
        isPageOpened = itemPage.clickAddToCartButton(testItemName)
        .clickShoppingBasket(testItemName).isPageOpen();
        Assert.assertTrue(isPageOpened, "BasketPage is not opened");
        isPageOpened = basketPage.clickCheckoutButton().isPageOpen();
        Assert.assertTrue(isPageOpened, "CheckoutPage is not opened");
        isPageOpened = checkoutPage.clickCancelButton().isPageOpen();
        Assert.assertTrue(isPageOpened, "BasketPage is not opened");
        productsPage.back();
        isPageOpened = checkoutPage.setFirstNameInput("kjdsvb")
                .setLastNameInput("djfndf")
                .setZipCodeInput("2356423")
                .clickContinueButton().isPageOpen();
        Assert.assertTrue(isPageOpened, "CheckoutOverviewPage is not opened");
    }

    @Description("Check negative input parameters and buttons in the checkout page")
    @Test(dataProvider = "NegativeCheckout", description = "Performance of input parameters and button", groups = {"regression"})
    public void negativeCheckoutTest(String testFirstName, String testLastName, String testZipCode) {
        String testItemName = "Sauce Labs Bike Light";

        boolean isPageOpened = loginPage
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton().isPageOpen();
        Assert.assertTrue(isPageOpened, "ProductsPage is not opened");
        isPageOpened = productsPage.openItem(testItemName).isPageOpen();
        Assert.assertTrue(isPageOpened, "ItemPage is not opened");
        isPageOpened = itemPage.clickAddToCartButton(testItemName)
                .clickShoppingBasket(testItemName).isPageOpen();
        Assert.assertTrue(isPageOpened, "BasketPage is not opened");
        isPageOpened = basketPage.clickCheckoutButton().isPageOpen();
        Assert.assertTrue(isPageOpened, "CheckoutPage is not opened");
        isPageOpened = checkoutPage.clickCancelButton().isPageOpen();
        Assert.assertTrue(isPageOpened, "BasketPage is not opened");
        productsPage.back();
        checkoutPage.setFirstNameInput(testFirstName)
                .setLastNameInput(testLastName)
                .setZipCodeInput(testZipCode)
                .clickContinueButton();
        Assert.assertTrue(checkoutPage.isFirstNameInputPresent());
        productsPage.back();
        basketPage.clickRemoveButton();
        isPageOpened = productsPage.clickBurgerButton().clickLogoutButton().isPageOpen();
        Assert.assertTrue(isPageOpened, "LoginPage is not opened");
    }

    @Description("Check input parameters and button in the checkout page without item")
    @Test(description = "Continue button shouldn't click without item", groups = {"regression"})
    public void negativeCheckoutTestWithoutItem()   {
        String testItemName = "Sauce Labs Bike Light";

        boolean isPageOpened = loginPage
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton().isPageOpen();
        Assert.assertTrue(isPageOpened, "ProductsPage is not opened");
        isPageOpened = productsPage.openItem(testItemName).isPageOpen();
        Assert.assertTrue(isPageOpened, "ItemPage is not opened");
        isPageOpened = itemPage.clickAddToCartButton(testItemName)
                .clickShoppingBasket(testItemName).isPageOpen();
        Assert.assertTrue(isPageOpened, "BasketPage is not opened");
        isPageOpened = basketPage.clickCheckoutButton().isPageOpen();
        Assert.assertTrue(isPageOpened, "CheckoutPage is not opened");
        checkoutPage.setFirstNameInput("kjdsvb")
        .setLastNameInput("djfndf")
        .setZipCodeInput("2356423")
        .clickContinueButton();
        Assert.assertTrue(checkoutPage.isFirstNameInputPresent());
    }
}