package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends BasePage  {
    @FindBy(id = "back-to-products")
    private WebElement BACK_TO_PRODUCT_BUTTON;
    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    private WebElement ITEM_NAME;
    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    private WebElement ITEM_DESCRIPTION;
    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    private WebElement ADD_TO_CART_BUTTON;
    @FindBy(className = "inventory_details_price")
    private WebElement ITEM_PRICE;
    @FindBy(className = "shopping_cart_link")
    private WebElement SHOPPING_BASKET;
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement SHOPPING_BASKET_FULL;

    public ItemPage(WebDriver driver)   {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Is present back to product button")
    public boolean isBackToProductButtonPresent()   {
        try {
            BACK_TO_PRODUCT_BUTTON.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Have some products in the shopping basket")
    public boolean isShoppingBasketFull()   {
        try {
            SHOPPING_BASKET_FULL.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Get item name")
    public String getItemName(String itemName)  {
        return ITEM_NAME.getText();
    }

    @Step("Get item description")
    public String getItemDescription(String itemName)   {
        return ITEM_DESCRIPTION.getText();
    }

    @Step("Click add to cart button")
    public ItemPage clickAddToCartButton(String itemName)   {
        ADD_TO_CART_BUTTON.click();
        return new ItemPage(driver);
    }

    @Step("Get item price")
    public String getItemPrice(String itemName) {
        return ITEM_PRICE.getText();
    }

    @Step("Click shopping basket button")
    public BasketPage clickShoppingBasket(String itemName)    {
        SHOPPING_BASKET.click();
        return new BasketPage(driver);
    }

    @Override
    public boolean isPageOpen() {
        return BACK_TO_PRODUCT_BUTTON.isDisplayed();
    }
}