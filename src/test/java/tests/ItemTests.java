package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Retry;

public class ItemTests extends BaseTests    {

    @Description("Data consistency check in the item page")
    @Test(dataProvider = "ItemList", retryAnalyzer = Retry.class, description = "Data reconciliation and " +
            "clickability buttons", groups = {"regression"})
    public void itemTest(String testItemName, String testItemPrice, String testItemDescription)  {

        boolean isPageOpen = loginPage.setUsername("standard_user")
        .setPassword("secret_sauce")
        .clickLoginButton().isPageOpen();
        Assert.assertTrue(isPageOpen, "ProductsPage is not opened");

        isPageOpen = productsPage.openItem(testItemName).isPageOpen();
        Assert.assertTrue(isPageOpen, "ItemPage is not opened");
        Assert.assertEquals(itemPage.getItemName(testItemName), testItemName);
        Assert.assertEquals(itemPage.getItemDescription(testItemName), testItemDescription);
        Assert.assertEquals(itemPage.getItemPrice(testItemName), testItemPrice);
        itemPage.clickAddToCartButton(testItemName);
        Assert.assertTrue(itemPage.isShoppingBasketFull());
        isPageOpen = itemPage.clickShoppingBasket(testItemName).isPageOpen();
        Assert.assertTrue(isPageOpen, "ShoppingBasket in not opened");
    }
}