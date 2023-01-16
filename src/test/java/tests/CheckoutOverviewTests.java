package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTests extends BaseTests    {

    @Description("Validation of data and buttons in the checkout overview page")
    @Test(description = "Validation of data and buttons", groups = {"regression"})
    public void checkoutOverviewTest()   {
        String testItemName = "Sauce Labs Bike Light";
        String testItemDescription = "A red light isn't the desired state in testing but it sure helps when riding " +
                "your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
        String testItemPrice = "$9.99";

        loginPage.setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton().isPageOpen();
        productsPage.openItem(testItemName);
        itemPage.clickAddToCartButton(testItemName)
                .clickShoppingBasket(testItemName).isPageOpen();
        basketPage.clickCheckoutButton();
        checkoutPage.setFirstNameInput("kjdsvb")
                .setLastNameInput("djfndf")
                .setZipCodeInput("2356423")
                .clickContinueButton();
        checkoutOverviewPage.getItemName(testItemName);
        Assert.assertEquals(checkoutOverviewPage.getItemName(testItemName), testItemName);
        checkoutOverviewPage.getItemDescription(testItemName);
        Assert.assertEquals(checkoutOverviewPage.getItemDescription(testItemName), testItemDescription);
        checkoutOverviewPage.getItemPrice(testItemName);
        Assert.assertEquals(checkoutOverviewPage.getItemPrice(testItemName), testItemPrice);
        boolean isPageOpen = checkoutOverviewPage.clickCancelButton().isPageOpen();
        Assert.assertTrue(isPageOpen, "ProductsPage is not opened");
        productsPage.back();
        isPageOpen = checkoutOverviewPage.clickShoppingBasketButton().isPageOpen();
        Assert.assertTrue(isPageOpen, "BasketPage is not opened");
        productsPage.back();
        isPageOpen = checkoutOverviewPage.clickFinishButton().isPageOpen();
        Assert.assertTrue(isPageOpen, "CheckoutCompetePage is not opened");
    }
}