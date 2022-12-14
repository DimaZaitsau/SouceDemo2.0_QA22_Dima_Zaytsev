package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{

    private final static By ITEM_NAME = By.className("inventory_item_name");
    private final static By ITEM_DESCRIPTION = By.cssSelector(".inventory_item_desc");
    private final static By ITEM_PRICE = By.cssSelector(".inventory_item_price");
    private final static By CHECKOUT_BUTTON = By.id("checkout");
    private final static By REMOVE_BUTTON = By.xpath("//button[@class='btn btn_secondary btn_small cart_button']");
    private final static By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private final static By NUMBER_OF_ITEMS_IN_BASKET = By.xpath("//span[@class='shopping_cart_badge']");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Step("Is present checkout button")
    public boolean isCheckoutButtonPresent()    {
        try {
            driver.findElement(CHECKOUT_BUTTON);
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

    @Step("Get item price")
    public String getItemPrice(String itemName) {
        return driver.findElement(ITEM_PRICE).getText();
    }

    @Step("Click checkout button")
    public void clickCheckoutButton()    {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("Click remove button")
    public void clickRemoveButton()  {
        driver.findElement(REMOVE_BUTTON).click();
    }

    @Step("Click continue shopping button")
    public void clickContinueShoppingButton()    {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    @Step("Have some items in basket")
    public boolean numberOfItemsInBasket()  {
        try {
            driver.findElement(NUMBER_OF_ITEMS_IN_BASKET).isDisplayed();
        }   catch (NoSuchElementException ex)   {
            return false;
        }
        return true;
    }
}