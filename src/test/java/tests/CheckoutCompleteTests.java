package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTests extends BaseTests {

    @Test
    public void checkoutCompleteTest()  {
        String testItemName = "Sauce Labs Bike Light";

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
        checkoutOverviewPage.clickFinishButton();
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isDropdownPresent());
    }
}
