package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests   {

    @Test
    public void positiveLoginTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isShoppingCartButtonPresent());
    }
}