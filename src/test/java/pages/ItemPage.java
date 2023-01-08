package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ItemPage extends BasePage  {
    private final static By BACK_TO_PRODUCT_BUTTON = By.id("back-to-products");
    private final static By ITEM_NAME = By.xpath("//div[@class='inventory_details_name large_size']");
    private final static By ITEM_DESCRIPTION = By.xpath("//div[@class='inventory_details_desc large_size']");
    private final static By ADD_TO_CART_BUTTON = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
    private final static By ITEM_PRICE = By.className("inventory_details_price");
    private final static By SHOPPING_BASKET = By.className("shopping_cart_link");
    private final static By SHOPPING_BASKET_FULL = By.xpath("//span[@class='shopping_cart_badge']");

    public ItemPage(WebDriver driver)   {
        super(driver);
    }

    @Step("Is present back to product button")
    public boolean isBackToProductButtonPresent()   {
        try {
            driver.findElement(BACK_TO_PRODUCT_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Have some products in the shopping basket")
    public boolean isShoppingBasketFull()   {
        try {
            driver.findElement(SHOPPING_BASKET_FULL);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Get item name")
    public String getItemName(String itemName)  {
        return driver.findElement(ITEM_NAME).getText();
    }

    @Step("Get item description")
    public String getItemDescription(String itemName)   {
        return driver.findElement(ITEM_DESCRIPTION).getText();
    }

    @Step("Click add to cart button")
    public void clickAddToCartButton(String itemName)   {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    @Step("Get item price")
    public String getItemPrice(String itemName) {
        return driver.findElement(ITEM_PRICE).getText();
    }

    @Step("Click shopping basket button")
    public void clickShoppingBasket(String itemName)    {
        driver.findElement(SHOPPING_BASKET).click();
    }
}