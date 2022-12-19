package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTests extends BaseTests    {

    @Test(description = "Validation of data and buttons", groups = {"slow"})
    public void checkoutOverviewTest()   {
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
        basketPage.clickCheckoutButton();
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

        productsPage.back();

        checkoutOverviewPage.clickShoppingBasketButton();
        Assert.assertTrue(basketPage.isCheckoutButtonPresent());
        productsPage.back();
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.isFinishTextPresent());
    }
}