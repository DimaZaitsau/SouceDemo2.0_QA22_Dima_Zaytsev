package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTests extends BaseTests {

    @Description("Button functionality on the checkout complete page")
    @Test(description = "Performance button on the page checkout complete", groups = {"regression"})
    public void checkoutCompleteTest()  {
        String testItemName = "Sauce Labs Bike Light";

        loginPage.setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton();
        productsPage.openItem(testItemName);
        itemPage.clickAddToCartButton(testItemName)
                .clickShoppingBasket(testItemName);
        basketPage.clickCheckoutButton();
        checkoutPage.setFirstNameInput("kjdsvb")
                .setLastNameInput("djfndf")
                .setZipCodeInput("2356423")
                .clickContinueButton();
        boolean isPageOpen = checkoutOverviewPage.clickFinishButton()
                .clickBackHomeButton().isPageOpen();
        Assert.assertTrue(isPageOpen, "ProductsPage is not opened");
    }
}