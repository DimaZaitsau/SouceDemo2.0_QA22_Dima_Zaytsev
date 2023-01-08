package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage  {

    private final static By ITEM_NAME = By.xpath("//div[@class='inventory_item_name']");
    private final static By ITEM_DESCRIPTION = By.cssSelector(".inventory_item_desc");
    private final static By ITEM_PRICE = By.cssSelector(".inventory_item_price");
    private final static By CANCEL_BUTTON = By.id("cancel");
    private final static By SHOPPING_BASKET_BUTTON = By.xpath("//a[@class='shopping_cart_link']");
    private final static By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver)   {
        super(driver);
    }

    @Step("Is present finish button")
    public boolean isFinishButtonPresent()  {
        try {
            driver.findElement(FINISH_BUTTON);
        }   catch (NoSuchElementException ex)   {
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

    @Step("Click cancel button")
    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    @Step("Click shopping basket button")
    public void clickShoppingBasketButton() {
        driver.findElement(SHOPPING_BASKET_BUTTON).click();
    }

    @Step("Click finish button")
    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }
}