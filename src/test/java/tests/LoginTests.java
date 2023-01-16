package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests   {

    @Description("Check login page and logout")
    @Test(description = "Checking input parameters for login page", groups = {"smoke"})
    public void positiveLoginTest() {
        boolean isPageOpened = loginPage
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton().isPageOpen();
        Assert.assertTrue(isPageOpened, "ProductsPage is not opened");
        isPageOpened = productsPage
                .clickBurgerButton()
                .clickLogoutButton().isPageOpen();
        Assert.assertTrue(isPageOpened, "LoginPage is not opened");
    }
}