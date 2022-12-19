package tests;

import org.testng.annotations.Test;

public class SortingTests extends BaseTests {

    @Test(description = "Correct sorting", groups = {"slow"})
    public void sortingTest()   {
        String expectedFirstSortingItemList = "Sauce Labs Backpack, Sauce Labs Bike Light, Sauce Labs Bolt T-Shirt, " +
                "Sauce Labs Fleece Jacket, Sauce Labs Onesie, Test.allTheThings() T-Shirt (Red)";
        String expectedSecondSortingItemList = "Test.allTheThings() T-Shirt (Red), Sauce Labs Onesie, " +
                "Sauce Labs Fleece Jacket, Sauce Labs Bolt T-Shirt, Sauce Labs Bike Light, Sauce Labs Backpack";
        String expectedThirdSortingItemList = "Sauce Labs Onesie, Sauce Labs Bike Light, Sauce Labs Bolt T-Shirt, " +
                "Test.allTheThings() T-Shirt (Red), Sauce Labs Backpack, Sauce Labs Fleece Jacket";
        String expectedFourthSortingItemName = "Sauce Labs Fleece Jacket, Sauce Labs Backpack, " +
                "Test.allTheThings() T-Shirt (Red), Sauce Labs Bolt T-Shirt, Sauce Labs Bike Light, Sauce Labs Onesie";

        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();



    }
}
