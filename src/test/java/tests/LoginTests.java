package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests   {

    @Description("Check login page and logout")
    @Test(description = "Checking input parameters for login page", groups = {"smoke"})
    public void positiveLoginTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isShoppingCartButtonPresent());
        productsPage.clickBurgerButton();
        productsPage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLoginButtonPresent());
    }
}